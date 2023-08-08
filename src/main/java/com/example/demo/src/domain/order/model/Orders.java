package com.example.demo.src.domain.order.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Builder
    public Orders(String postId, Long customerId, String payment, String deliveryAddress, Integer price, Integer quantity) {
        this.postId = postId;
        this.customerId = customerId;
        this.payment = payment;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.quantity = quantity;
    }

    public void changeOrder(Orders ordersEdit){
         this.payment = ordersEdit.payment;
         this.deliveryAddress = deliveryAddress;
         this.price = price;
         this.quantity = quantity;
    }

    public int getTotalPrice(){
        return price*quantity;
    }
}
