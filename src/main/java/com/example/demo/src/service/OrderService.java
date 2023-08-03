package com.example.demo.src.service;

import com.example.demo.src.domain.Order;
import com.example.demo.src.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public void get(Long orderID) {
        orderRepository.get(orderID);
    }

    public List<Order> getList(){
        return orderRepository.list();
    }

    public void addOrder(Order order) {
        Long orderId = order.addOrderId();
        orderRepository.add(orderId, order);
    }

    public void patchOrder(Long orderID, Order orderEdit) {
        orderRepository.patch(orderID, orderEdit);
    }
}
