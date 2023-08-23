package com.example.demo.src.domain.login;

import com.example.demo.src.domain.user.model.UserRole;
import lombok.Getter;

@Getter
public class UserSession {
    private Long id;
    private UserRole userRole;

    public UserSession(Long id, UserRole userRole) {
        this.id = id;
        this.userRole = userRole;
    }
}