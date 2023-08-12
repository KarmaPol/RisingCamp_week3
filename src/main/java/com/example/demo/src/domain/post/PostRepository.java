package com.example.demo.src.domain.post;

import com.example.demo.src.domain.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {

//    @Override
//    @Query("select p from Post p join fetch p.user")
//    List<Post> findAll();
}