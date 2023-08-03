package com.example.demo.src.service;

import com.example.demo.src.domain.Post;
import com.example.demo.src.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getList(){
        return postRepository.list();
    }

    public Post get(Long postId) {
        return postRepository.get(postId);
    }

    public void post(Post post) {
        Long postId = post.addPostId();
        postRepository.add(postId, post);
    }

    public void patch(Long postID, Post post) {
        postRepository.patch(postID, post);
    }
}
