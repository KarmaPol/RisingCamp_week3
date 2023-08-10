package com.example.demo.src.domain.post;

import com.example.demo.src.domain.order.OrderRepository;
import com.example.demo.src.domain.order.model.Orders;
import com.example.demo.src.domain.post.model.Post;
import com.example.demo.src.domain.user.UserRepository;
import com.example.demo.src.domain.user.model.Users;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void before(){
    }

    @Test
    @DisplayName("N+1 문제 테스트")
    void test1(){
        // given
        Users user1 = Users.builder().name("test1").address("add1").password("aaaddd").phoneNumber("12345").build();
        Users user2 = Users.builder().name("test2").address("add1").password("aaaddd").phoneNumber("12345").build();
        Users user3 = Users.builder().name("test3").address("add1").password("aaaddd").phoneNumber("12345").build();
        userRepository.saveAll(Lists.list(user1, user2, user3));

        Post post1 = Post.builder().title("post1").price(123).content("con").quantity(12).build();
        post1.setUser(user1);
        Post post2 = Post.builder().title("post1").price(123).content("con").quantity(12).build();
        post2.setUser(user2);
        Post post3 = Post.builder().title("post1").price(123).content("con").quantity(12).build();
        post3.setUser(user3);

        Orders order1 = Orders.builder().quantity(1).deliveryAddress(user1.getAddress()).payment("현대").price(post1.getPrice()).build();
        Orders order2 = Orders.builder().quantity(1).deliveryAddress(user1.getAddress()).payment("현대").price(post1.getPrice()).build();
        order1.setUser(user1); order1.setPost(post1);
        order2.setUser(user1); order2.setPost(post1);

        Orders order3 = Orders.builder().quantity(1).deliveryAddress(user2.getAddress()).payment("현대").price(post2.getPrice()).build();
        Orders order4 = Orders.builder().quantity(1).deliveryAddress(user2.getAddress()).payment("현대").price(post2.getPrice()).build();
        order3.setUser(user2); order3.setPost(post2);
        order4.setUser(user2); order4.setPost(post2);

        Orders order5 = Orders.builder().quantity(1).deliveryAddress(user3.getAddress()).payment("현대").price(post3.getPrice()).build();
        Orders order6 = Orders.builder().quantity(1).deliveryAddress(user3.getAddress()).payment("현대").price(post3.getPrice()).build();
        order5.setUser(user3); order5.setPost(post3);
        order6.setUser(user3); order6.setPost(post3);

        //when


    }
}