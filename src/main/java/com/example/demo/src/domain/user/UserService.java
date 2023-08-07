package com.example.demo.src.domain.user;

import com.example.demo.src.domain.user.model.User;
import com.example.demo.src.exception.ResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 일반 회원가입
    public void register(User user){
        userRepository.save(user);
    }

    // 전체 회원 조회
    public List<User> getList(){
        return userRepository.findAll();
    }

    // 회원 이름 중복검사
    public boolean duplicateValidation(String userName){
        return userRepository.countUserByName(userName) <= 0;
    }

    // 회원 정보 조회
    public User getUser(Long userID){
        return userRepository.findById(userID).orElseThrow(() -> new ResourceException());
    }

    // 회원 정보 수정
    public void patchUser(Long userID, User user){
        User findUser = userRepository.findById(userID).orElseThrow(() -> new ResourceException());
        findUser.changeUser(user);
    }

    // 회원 탈퇴
    public void deleteUser(Long userID){
        User findUser = userRepository.findById(userID).orElseThrow(() -> new ResourceException());
        userRepository.delete(findUser);
    }
}
