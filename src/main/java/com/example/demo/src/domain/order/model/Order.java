package com.example.demo.src.domain.order.model;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

public class Order {
    private static Long idSeq = 0L;
    private Long orderId;
    @NotBlank
    private String postId;
    @NotBlank
    private Long customerId;
    @NotBlank
    private String payment;
    @NotBlank
    private String deliveryAddress;
    @NotBlank
    private Integer price;
    @NotBlank
    private Integer quantity;

    public Long addOrderId(){
        orderId = idSeq;
        idSeq++;
        return orderId;
    }

    @Builder
    public Order(String postId, Long customerId, String payment, String deliveryAddress, Integer price, Integer quantity) {
        this.postId = postId;
        this.customerId = customerId;
        this.payment = payment;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.quantity = quantity;
    }

    public void changeOrder(Order orderEdit){
         this.payment = orderEdit.payment;
         this.deliveryAddress = deliveryAddress;
         this.price = price;
         this.quantity = quantity;
    }

    public int getTotalPrice(){
        return price*quantity;
    }
}
