package com.example.demo.src.domain.post.resp;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class PostResp {

    private Long postId;
    private String title;
    private String content;
    private String itemId;
    private Integer price;
    private Integer quantity;
    private Long userId;

    @Builder
    public PostResp(Long postId, String title, String content, String itemId, Integer price, Integer quantity, Long userId) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
        this.userId = userId;
    }
}
