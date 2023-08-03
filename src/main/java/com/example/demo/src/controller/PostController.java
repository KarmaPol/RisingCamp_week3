package com.example.demo.src.controller;

import com.example.demo.src.domain.Post;
import com.example.demo.src.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 전체 상품게시글 조회
    @GetMapping("/posts")
    public void postlist(){
        postService.getList();
    }

    // 특정 게시글 조회
    @GetMapping("/posts/{postID}")
    public Post getPost(@Valid @RequestParam Long postID){
        return postService.get(postID);
    }

    // 상품게시글 작성 - seller 권한 요구
    @PostMapping("/posts")
    public void post(@Valid @RequestBody Post post){
        postService.post(post);
    }

    // 상품게시글 수정 - seller & 본인 게시글 권한 요구
    @PatchMapping("/posts/{postID}")
    public void patchPost(@RequestParam Long postID, @Valid @RequestBody Post post){
        postService.patch(postID, post);
    }
}
