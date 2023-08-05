package com.example.demo.src.domain.user;

import com.example.demo.src.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public Long countUserByName(String name);
}
