package com.example.demo.src.domain;

import com.example.demo.src.domain.user.model.Users;

public class Seller extends Users {

    private static Long idSeq = 0L;

    private String sellerID;

    public String addSellerID(){
        sellerID = "seller" + Long.toString(idSeq);
        idSeq++;
        return sellerID;
    }
}
