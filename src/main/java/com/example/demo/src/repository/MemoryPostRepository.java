package com.example.demo.src.repository;

import com.example.demo.src.domain.Post;
import com.example.demo.src.domain.Post;
import org.springframework.stereotype.Repository;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryPostRepository implements PostRepository {
    private static Map<Long, Post> postMap = new HashMap<>();

    @Override
    public Post get(Long postID) {
        return postMap.get(postID);
    }

    @Override
    public void add(Long id, Post post) {
        postMap.put(id, post);
    }

    @Override
    public void patch(Long postID, Post post) {
        postMap.remove(postID);
        postMap.put(postID, post);
    }

    @Override
    public void delete(Long postID) {
        postMap.remove(postID);
    }

    @Override
    public List<Post> list() {
        List<Post> postList = new ArrayList<>();
        for(Long postID : postMap.keySet()) {
            postList.add(postMap.get(postID));
        }
        return postList;
    }
}
