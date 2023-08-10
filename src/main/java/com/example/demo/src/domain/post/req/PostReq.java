package com.example.demo.src.domain.post.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class PostReq {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String itemId;
    @NotBlank
    private Integer price;
    @NotBlank
    private Integer quantity;
    @NotBlank
    private Long userId;

    @Builder
    public PostReq(String title, String content, String itemId, Integer price, Integer quantity, Long userId) {
        this.title = title;
        this.content = content;
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
        this.userId = userId;
    }
}
