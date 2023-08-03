package com.example.demo.src.controller;

import com.example.demo.src.domain.Order;
import com.example.demo.src.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    // 특정 주문 조회
    @GetMapping("/orders/{orderID}")
    public void getOrder(@PathVariable Long orderID){
        orderService.get(orderID);
    }

    // 전체 주문 조회
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getList();
    }

    // 상품 주문
    @PostMapping("/orders")
    public void order(@RequestBody Order order){
        orderService.addOrder(order);
    }

    // 주문 수정
    @PatchMapping("/orders/{orderID}")
    public void patch(@RequestParam Long orderID, @Valid @RequestBody Order order){
        orderService.patchOrder(orderID, order);
    }
}
