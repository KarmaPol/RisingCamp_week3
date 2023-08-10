package com.example.demo.src.domain.user.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserEditReq {
    @NotNull
    private String name;
    @NotNull
    private String password;
    private String phoneNumber;
    private String address;

    @Builder
    public UserEditReq(String name, String password, String phoneNumber, String address) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
