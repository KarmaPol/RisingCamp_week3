package com.example.demo.src.domain.user.req;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
public class SignupReq {
    @NotNull
    private String name;
    @NotNull
    private String password;
    private String phoneNumber;
    private String address;

    @Builder
    public SignupReq(String name, String password, String phoneNumber, String address) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
