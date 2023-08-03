package com.example.demo.src.repository;

import com.example.demo.src.domain.Post;
import com.example.demo.src.domain.User;
import com.example.demo.src.service.UserService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryUserRepository implements UserRepository {
    private static Map<Long, User> userMap = new HashMap<>();

    @Override
    public User get(Long userID) {
        return userMap.get(userID);
    }

    @Override
    public void add(Long userID, User user) {
        userMap.put(userID, user);
    }

    @Override
    public void patch(Long userID, User user) {
        userMap.remove(userID);
        userMap.put(userID, user);
    }

    @Override
    public void delete(Long userID) {
        userMap.remove(userID);
    }

    @Override
    public List<User> list() {
        List<User> userList = new ArrayList<>();
        for(Long userID : userMap.keySet()) {
            userList.add(userMap.get(userID));
        }
        return userList;
    }

    @Override
    public boolean duplicateValidation() {
        return false;
    }
}
