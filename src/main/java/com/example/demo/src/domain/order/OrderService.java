package com.example.demo.src.domain.order;

import com.example.demo.src.domain.order.model.Orders;
import com.example.demo.src.domain.order.req.OrderReq;
import com.example.demo.src.domain.order.resp.OrderResp;
import com.example.demo.src.domain.post.PostRepository;
import com.example.demo.src.domain.post.model.Post;
import com.example.demo.src.domain.user.UserRepository;
import com.example.demo.src.domain.user.model.Users;
import com.example.demo.src.exception.model.ResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public OrderResp get(Long orderID) {
        Orders order = orderRepository.findById(orderID).orElseThrow(() -> new ResourceException());
        OrderResp orderResp = OrderResp.builder().orderId(order.getOrderId()).postId(order.getPost().getPostId()).userId(order.getUser().getUserId()).quantity(order.getQuantity())
                .payment(order.getPayment()).deliveryAddress(order.getDeliveryAddress()).price(order.getPrice()).build();

        return orderResp;
    }

    @Transactional(readOnly = true)
    public List<OrderResp> getList(){
        List<Orders> ordersList = orderRepository.findAll();

        return ordersList.stream().map(order -> OrderResp.builder().orderId(order.getOrderId()).postId(order.getPost().getPostId())
                .userId(order.getUser().getUserId()).quantity(order.getQuantity())
                    .payment(order.getPayment()).deliveryAddress(order.getDeliveryAddress()).price(order.getPrice()).build()
        ).collect(Collectors.toList());
    }

    public void addOrder(OrderReq orderReq) {
        Users user = userRepository.findById(orderReq.getUserId()).orElseThrow(() -> new ResourceException());
        Post post = postRepository.findById(orderReq.getPostId()).orElseThrow(() -> new ResourceException());
        Orders order = Orders.builder().price(orderReq.getPrice()).payment(orderReq.getPayment()).deliveryAddress(orderReq.getDeliveryAddress())
                .quantity(orderReq.getQuantity()).build();

        order.setPost(post); order.setUser(user);

        orderRepository.save(order);
    }

    public void patchOrder(Long orderID, OrderReq orderEdit) {
        Orders findOrder = orderRepository.findById(orderID).orElseThrow(() -> new ResourceException());

        findOrder.changeOrder(orderEdit);
    }
}
