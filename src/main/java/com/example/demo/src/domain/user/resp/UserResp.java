package com.example.demo.src.domain.user.resp;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResp {
    private String name;
    private String phoneNumber;
    private String address;

    @Builder
    public UserResp(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
