package com.example.demo.src.domain.user.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import static com.example.demo.utils.ValidationRegex.isRegexEmail;

@Getter
@NoArgsConstructor
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

    public boolean validateName(){
        return isRegexEmail(name);
    }
}
