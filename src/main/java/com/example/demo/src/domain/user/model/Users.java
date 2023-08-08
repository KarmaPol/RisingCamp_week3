package com.example.demo.src.domain.user.model;

import com.example.demo.src.domain.user.req.UserEditReq;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Entity
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public Users(String name, String password, String phoneNumber, String address) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void changeUser(UserEditReq userEditReq){
        this.name = userEditReq.getName();
        this.password = userEditReq.getPassword();
        this.phoneNumber = userEditReq.getPhoneNumber();
        this.address = userEditReq.getAddress();
    }
}
