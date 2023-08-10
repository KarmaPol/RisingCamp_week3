package com.example.demo.src.domain.user.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class LoginReq {
    @NotNull
    private String name;
    @NotNull
    private String password;

    @Builder
    public LoginReq(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
