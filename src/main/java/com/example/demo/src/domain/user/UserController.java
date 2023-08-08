package com.example.demo.src.domain.user;

import com.example.demo.src.domain.Seller;
import com.example.demo.src.domain.user.req.SignupReq;
import com.example.demo.src.domain.user.req.UserEditReq;
import com.example.demo.src.domain.user.resp.UserResp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 일반 회원 가입
    @PostMapping("/users")
    public void register(@Valid @RequestBody SignupReq signupReq){
        userService.register(signupReq);
    }

    // 전체 회원 조회
    @GetMapping("/users")
    public List<UserResp> members(){
        return userService.getList();
    }

    // 회원 ID 중복 검사
    @GetMapping("/users/duplicate-validation")
    public boolean isDuplicateID(@RequestParam String name){
        return userService.duplicateValidation(name);
    }

    // 회원 정보 조회
    @GetMapping("/users/{userID}")
    public UserResp getUserInfo(@PathVariable Long userID){
        return userService.getUser(userID);
    }

    // 회원 정보 수정
    @PatchMapping("/users/{userID}")
    public void patchUserID(@PathVariable Long userID, @RequestBody UserEditReq userEditReq){
        userService.patchUser(userID, userEditReq);
    }

    // 회원 탈퇴
    @DeleteMapping("/users/{userID}")
    public void deleteUser(@PathVariable Long userID){
        userService.deleteUser(userID);
    }
}
