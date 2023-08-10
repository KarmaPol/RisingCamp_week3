package com.example.demo.src.domain.order.model;

import com.example.demo.src.domain.order.req.OrderReq;
import com.example.demo.src.domain.post.model.Post;
import com.example.demo.src.domain.user.model.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @BatchSize(size = 100)
    @JoinColumn(name = "post_id")
    @NotBlank
    private Post post;

    @ManyToOne
    @BatchSize(size = 100)
    @JoinColumn(name = "user_id")
    @NotBlank
    private Users user;

    @NotBlank
    private String payment;
    @NotBlank
    private String deliveryAddress;
    @NotBlank
    private Integer price;
    @NotBlank
    private Integer quantity;

    @Builder
    public Orders(String payment, String deliveryAddress, Integer price, Integer quantity) {
        this.payment = payment;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.quantity = quantity;
    }

    public void changeOrder(OrderReq ordersEdit){
         this.payment = ordersEdit.getPayment();
         this.deliveryAddress = ordersEdit.getDeliveryAddress();
         this.price = ordersEdit.getPrice();
         this.quantity = ordersEdit.getQuantity();
    }

    public int getTotalPrice(){
        return price*quantity;
    }

    // Post 편의 메소드
    public void setPost(Post post){
        if(this.post != null){
            this.post.getOrder().remove(this);
        }
        this.post = post;
        post.getOrder().add(this);
    }

    // User 편의 메소드
    public void setUser(Users user){
        if(this.user != null){
            this.user.getOrder().remove(this);
        }
        this.user = user;
        user.getOrder().add(this);
    }
}
