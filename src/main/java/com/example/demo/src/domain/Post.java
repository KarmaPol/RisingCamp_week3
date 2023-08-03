package com.example.demo.src.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class Post {
    private static Long idSeq = 0L;
    private Long postId;
    @NotBlank
    private String title;
    private String content;
    @NotBlank
    private String itemId;
    private Integer quantity;

    public Long addPostId(){
        postId = idSeq;
        idSeq++;
        return postId;
    }

    @Builder
    public Post(String title, String content, String itemId, Integer quantity) {
        this.title = title;
        this.content = content;
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
