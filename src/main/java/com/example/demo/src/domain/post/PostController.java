package com.example.demo.src.domain.post;

import com.example.demo.src.domain.login.UserSession;
import com.example.demo.src.domain.post.req.PostReq;
import com.example.demo.src.domain.post.resp.PostResp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 상품게시글 조회
    @GetMapping("/posts")
    public List<PostResp> postlist(@PageableDefault(page =0, size = 10, sort = "postId", direction = Sort.Direction.DESC) Pageable pageable){
        return postService.getList(pageable);
    }

    // 특정 게시글 조회
    @GetMapping("/posts/{postID}")
    public PostResp getPost(@Valid @RequestParam Long postID){
        return postService.get(postID);
    }

    // 상품게시글 작성 - seller 권한 요구
    @PostMapping("/posts")
    public void post(UserSession userSession, @Valid @RequestBody PostReq postreq){
        postService.post(postreq);
    }

    @PostMapping("/foo")
    public void foo(UserSession userSession){
        return;
    }

    // 상품게시글 수정 - seller & 본인 게시글 권한 요구
    @PatchMapping("/posts/{postID}")
    public void patchPost(UserSession userSession, @RequestParam Long postID, @Valid @RequestBody PostReq postReq){
        postService.patch(postID, postReq);
    }
}
