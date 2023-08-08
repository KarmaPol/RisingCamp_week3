package com.example.demo.src.domain.post.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @NotBlank
    private String title;
    private String content;
    @NotBlank
    private String itemId;
    private Integer price;
    private Integer quantity;

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
