package com.example.demo.src.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class User {

    private static Long idSeq = 0L;

    private Long userId;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    private String phoneNumber;
    private String address;

    @Builder
    public User(String name, String password, String phoneNumber, String address) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long addUserId(){
        userId = idSeq;
        idSeq++;
        return userId;
    }
}
