package com.example.demo.src.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    // 배송정보 조회
    @GetMapping("/delivery/{deliveryID}")
    public void getDelivery(){

    }

    // 배송정보 수정
    @PatchMapping("/delivery/{deliveryID}")
    public void patchDelivery(){

    }
}
