package com.example.demo.src.repository;

import com.example.demo.src.domain.Post;
import com.example.demo.src.domain.User;

import java.util.List;

public interface UserRepository {
    public User get(Long userID);
    public void add(Long userID, User user);
    public void patch(Long userID, User user);
    public void delete(Long userID);
    public List<User> list();
    public boolean duplicateValidation();
}
