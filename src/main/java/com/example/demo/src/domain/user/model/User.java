package com.example.demo.src.domain.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id @GeneratedValue
    private Long userId;
    @NotNull @Column
    private String name;
    @NotNull @Column
    private String password;
    @Column
    private String phoneNumber;
    @Column
    private String address;

    @Builder
    public User(String name, String password, String phoneNumber, String address) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void changeUser(User user){
        this.name = user.getName();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
    }
}
