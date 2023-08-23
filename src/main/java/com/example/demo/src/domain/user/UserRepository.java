package com.example.demo.src.domain.user;

import com.example.demo.src.domain.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    public Long countUserByName(String name);

    public Optional<Users> findByNameAndPassword(String name, String password);
    public Optional<Users> findByName(String name);
}
