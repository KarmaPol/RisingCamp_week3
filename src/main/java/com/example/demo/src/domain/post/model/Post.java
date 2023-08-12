package com.example.demo.src.domain.post.model;

import com.example.demo.src.domain.order.model.Orders;
import com.example.demo.src.domain.post.req.PostReq;
import com.example.demo.src.domain.user.model.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
    @NotNull
    private Long itemId;
    private Integer price;
    private Integer quantity;

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "post")
    private List<Orders> order = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Builder
    public Post(String title, String content, Long itemId, Integer quantity, Integer price) {
        this.title = title;
        this.content = content;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    public void changePost(PostReq postEdit){
        this.title = postEdit.getTitle();
        this.content = postEdit.getContent();
        this.itemId = postEdit.getItemId();
        this.quantity = postEdit.getQuantity();
        this.price = postEdit.getPrice();
    }

    public void setUser(Users user){
        this.user = user;
    }
}
