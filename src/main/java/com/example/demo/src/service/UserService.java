package com.example.demo.src.service;

import com.example.demo.src.domain.User;
import com.example.demo.src.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 일반 회원가입
    public void register(User user){
        Long userId = user.addUserId();

        userRepository.add(userId,user);
    }

    // 전체 회원 조회
    public List<User> getList(){
        return userRepository.list();
    }

    // 회원 이름 중복검사
    public boolean duplicateValidation(String userName){
        List<User> list = userRepository.list();

        for(User user : list){
            if(user.getName().equals(userName)) return false;
        }
        return true;
    }

    // 회원 정보 조회
    public User getUser(Long userID){
        return userRepository.get(userID);
    }

    // 회원 정보 수정
    public void patchUser(Long userID, User user){
        userRepository.patch(userID, user);
    }

    // 회원 탈퇴
    public void deleteUser(Long userID){
        userRepository.delete(userID);
    }
}
