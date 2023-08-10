package com.example.demo.src.domain.order.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class OrderReq {
    @NotBlank
    private Long postId;
    @NotBlank
    private Long userId;
    @NotBlank
    private String payment;
    @NotBlank
    private String deliveryAddress;
    @NotBlank
    private Integer price;
    @NotBlank
    private Integer quantity;

    @Builder
    public OrderReq(Long postId, Long userId, String payment, String deliveryAddress, Integer price, Integer quantity) {
        this.postId = postId;
        this.userId = userId;
        this.payment = payment;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.quantity = quantity;
    }
}
