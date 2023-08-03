package com.example.demo.src.repository;

import com.example.demo.src.domain.Order;

import java.util.List;

public interface OrderRepository {
    public void add(Long orderID, Order order);
    public List<Order> list();
    public void delete(Long postID);
    public void patch(Long orderID, Order order);
    public Order get(Long orderID);
}
