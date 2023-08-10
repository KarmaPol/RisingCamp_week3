package com.example.demo.src.domain.order.resp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class OrderResp {
    private Long orderId;
    private Long postId;
    private Long userId;
    private String payment;
    private String deliveryAddress;
    private Integer price;
    private Integer quantity;

    @Builder
    public OrderResp(Long orderId, Long postId, Long userId, String payment, String deliveryAddress, Integer price, Integer quantity) {
        this.orderId = orderId;
        this.postId = postId;
        this.userId = userId;
        this.payment = payment;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.quantity = quantity;
    }
}
