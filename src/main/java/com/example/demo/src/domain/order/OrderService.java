package com.example.demo.src.domain.order;

import com.example.demo.src.domain.order.model.Orders;
import com.example.demo.src.exception.ResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public void get(Long orderID) {
        orderRepository.findById(orderID);
    }

    public List<Orders> getList(){
        return orderRepository.findAll();
    }

    public void addOrder(Orders orders) {
        orderRepository.save(orders);
    }

    public void patchOrder(Long orderID, Orders ordersEdit) {
        Orders findOrders = orderRepository.findById(orderID).orElseThrow(() -> new ResourceException());
        findOrders.changeOrder(ordersEdit);
    }
}
