package com.example.demo.src.domain.post.resp;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResp {

    private Long postId;
    private String title;
    private String content;
    private Long itemId;
    private Integer price;
    private Integer quantity;
    private Long userId;

    @Builder
    public PostResp(Long postId, String title, String content, Long itemId, Integer price, Integer quantity, Long userId) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
        this.userId = userId;
    }
}
