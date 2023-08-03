package com.example.demo.src.repository;

import com.example.demo.src.domain.Post;
import com.example.demo.src.domain.User;

import java.util.List;

public interface PostRepository {
    public Post get(Long PostID);
    public void add(Long PostID, Post post);
    public void patch(Long PostID, Post post);
    public void delete(Long PostID);
    public List<Post> list();
}
