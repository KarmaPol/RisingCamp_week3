package com.example.demo.src.domain.user;

import com.example.demo.src.domain.login.UserSession;
import com.example.demo.src.domain.user.model.Users;
import com.example.demo.src.domain.user.req.LoginReq;
import com.example.demo.src.domain.user.req.SignupReq;
import com.example.demo.src.domain.user.req.UserEditReq;
import com.example.demo.src.domain.user.resp.UserResp;
import com.example.demo.src.exception.model.InvalidSigninException;
import com.example.demo.src.exception.model.NameDuplicateException;
import com.example.demo.src.exception.model.ResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private static final SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();

    // 일반 회원가입
    public void register(SignupReq signupReq){

        if(!duplicateValidation(signupReq.getName())) throw new NameDuplicateException();

        String encodedpasswrod = sCryptPasswordEncoder.encode(signupReq.getPassword());

        Users signupUsers = Users.builder().phoneNumber(signupReq.getPhoneNumber())
                .address(signupReq.getAddress())
                .name(signupReq.getName())
                .password(encodedpasswrod)
                .userRole(signupReq.getUserRole()).build();

        userRepository.save(signupUsers);
    }

    @Transactional(readOnly = true)
    // 전체 회원 조회
    public List<UserResp> getList(){
        List<Users> usersList = userRepository.findAll();

        List<UserResp> userRespList = usersList.stream().map(user -> {
                    return UserResp.builder().name(user.getName()).address(user.getAddress()).phoneNumber(user.getPhoneNumber()).build();
                })
                .collect(Collectors.toList());

        return userRespList;
    }

    @Transactional(readOnly = true)
    // 회원 이름 중복검사
    public boolean duplicateValidation(String userName){
        return userRepository.countUserByName(userName) <= 0;
    }

    @Transactional(readOnly = true)
    // 회원 정보 조회
    public UserResp getUser(Long userID){
        Users findUsers = userRepository.findById(userID).orElseThrow(() -> new ResourceException());
        return UserResp.builder().name(findUsers.getName()).address(findUsers.getAddress()).phoneNumber(findUsers.getPhoneNumber()).build();
    }

    // 회원 정보 수정
    public void patchUser(Long userID, UserEditReq userEditReq){
        Users findUsers = userRepository.findById(userID).orElseThrow(() -> new ResourceException());
        findUsers.changeUser(userEditReq);
    }

    // 회원 탈퇴
    public void deleteUser(Long userID){
        Users findUsers = userRepository.findById(userID).orElseThrow(() -> new ResourceException());
        userRepository.delete(findUsers);
    }

    public UserSession login(LoginReq login) {
        Users findUser = userRepository.findByName(login.getName()).orElseThrow(() -> new InvalidSigninException());

        if(!sCryptPasswordEncoder.matches(login.getPassword(), findUser.getPassword())) throw new InvalidSigninException();

        return new UserSession(findUser.getUserId(), findUser.getUserRole());
    }
}
