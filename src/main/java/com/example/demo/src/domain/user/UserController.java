package com.example.demo.src.domain.user;

import com.example.demo.src.config.AuthConfig;
import com.example.demo.src.domain.login.UserSession;
import com.example.demo.src.domain.user.req.LoginReq;
import com.example.demo.src.domain.user.req.SignupReq;
import com.example.demo.src.domain.user.req.UserEditReq;
import com.example.demo.src.domain.user.resp.UserResp;
import com.example.demo.src.exception.model.FormException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthConfig authConfig;

    // 일반 회원 가입
    @PostMapping("/users/sign-up")
    public void register(@Valid @RequestBody SignupReq signupReq){
        if(!signupReq.validateName()) throw new FormException();

        userService.register(signupReq);
    }

    // 로그인
    @PostMapping("/users/sign-in")
    public String signin(@RequestBody LoginReq login){
        UserSession loginUser = userService.login(login);

        SecretKey secretKey = Keys.hmacShaKeyFor(authConfig.getJwtKey());

        String jws = Jwts.builder().claim("id", String.valueOf(loginUser.getId())).claim("role", String.valueOf(loginUser.getUserRole()))
                .setIssuedAt(new Date()).signWith(secretKey).compact();

        return jws;
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
