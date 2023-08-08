package com.example.demo.src.domain.user;

import com.example.demo.src.domain.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    public Long countUserByName(String name);
}
