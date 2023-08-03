package com.example.demo.src.domain;

public class Seller extends User {

    private static Long idSeq = 0L;

    private String sellerID;

    public String addSellerID(){
        sellerID = "seller" + Long.toString(idSeq);
        idSeq++;
        return sellerID;
    }
}
