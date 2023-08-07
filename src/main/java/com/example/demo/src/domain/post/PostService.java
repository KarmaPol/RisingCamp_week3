package com.example.demo.src.domain.post;

import com.example.demo.src.domain.post.model.Post;
import com.example.demo.src.exception.ResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getList(){
        return postRepository.findAll();
    }

    public Post get(Long postID) {
        return postRepository.findById(postID).orElseThrow(() -> new ResourceException());
    }

    public void post(Post post) {
        postRepository.save(post);
    }

    public void patch(Long postID, Post post) {
        Post findPost = postRepository.findById(postID).orElseThrow(() -> new ResourceException());
    }
}
