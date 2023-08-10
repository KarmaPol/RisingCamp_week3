package com.example.demo.src.domain.post;

import com.example.demo.src.domain.post.model.Post;
import com.example.demo.src.domain.post.req.PostReq;
import com.example.demo.src.domain.post.resp.PostResp;
import com.example.demo.src.exception.model.ResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostResp> getList(){
        return postRepository.findAll().stream()
                .map(post -> PostResp.builder().postId(post.getPostId()).title(post.getTitle()).content(post.getContent())
                        .price(post.getPrice()).itemId(post.getItemId()).quantity(post.getQuantity()).userId(post.getUser().getUserId()).build())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostResp get(Long postID) {
        Post post = postRepository.findById(postID).orElseThrow(() -> new ResourceException());

        return PostResp.builder().postId(post.getPostId()).title(post.getTitle()).content(post.getContent())
                .price(post.getPrice()).itemId(post.getItemId()).quantity(post.getQuantity()).userId(post.getUser().getUserId()).build();
    }

    public void post(PostReq postReq) {
        Post post = Post.builder().title(postReq.getTitle()).content(postReq.getContent()).itemId(postReq.getItemId())
                        .price(postReq.getPrice()).quantity(postReq.getQuantity()).build();

        postRepository.save(post);
    }

    public void patch(Long postID, PostReq postReq) {
        Post findPost = postRepository.findById(postID).orElseThrow(() -> new ResourceException());

        findPost.changePost(postReq);
    }
}
