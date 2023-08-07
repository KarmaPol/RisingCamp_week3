package com.example.demo.src.domain.post.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
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
    private Integer price;
    private Integer quantity;

    public Long addPostId(){
        postId = idSeq;
        idSeq++;
        return postId;
    }

    @Builder
    public Post(String title, String content, String itemId, Integer quantity, Integer price) {
        this.title = title;
        this.content = content;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    public void changePost(Post postEdit){
        this.title = postEdit.getTitle();
        this.content = postEdit.getContent();
        this.itemId = postEdit.getItemId();
        this.quantity = postEdit.getQuantity();
        this.price = postEdit.getPrice();
    }
}
