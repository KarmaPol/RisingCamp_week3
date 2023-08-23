package com.example.demo.src.domain.post.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PostReq {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private Long itemId;
    private Integer price;
    private Integer quantity;
    @NotNull
    private Long userId;

    @Builder
    public PostReq(String title, String content, Long itemId, Integer price, Integer quantity, Long userId) {
        this.title = title;
        this.content = content;
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
        this.userId = userId;
    }
}
