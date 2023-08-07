package com.example.demo.src.domain.order;

import com.example.demo.src.domain.order.model.Order;
import com.example.demo.src.exception.ResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public void get(Long orderID) {
        orderRepository.findById(orderID);
    }

    public List<Order> getList(){
        return orderRepository.findAll();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public void patchOrder(Long orderID, Order orderEdit) {
        Order findOrder = orderRepository.findById(orderID).orElseThrow(() -> new ResourceException());
        findOrder.changeOrder(orderEdit);
    }
}
