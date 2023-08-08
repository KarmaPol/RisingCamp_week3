package com.example.demo.src.domain.order;

import com.example.demo.src.domain.order.model.Orders;
import lombok.RequiredArgsConstructor;
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
    public List<Orders> getOrders() {
        return orderService.getList();
    }

    // 상품 주문
    @PostMapping("/orders")
    public void order(@RequestBody Orders orders){
        orderService.addOrder(orders);
    }

    // 주문 수정
    @PatchMapping("/orders/{orderID}")
    public void patch(@RequestParam Long orderID, @Valid @RequestBody Orders orders){
        orderService.patchOrder(orderID, orders);
    }
}
