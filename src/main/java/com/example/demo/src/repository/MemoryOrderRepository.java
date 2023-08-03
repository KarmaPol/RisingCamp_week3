package com.example.demo.src.repository;

import com.example.demo.src.domain.Order;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryOrderRepository implements OrderRepository{

    private static Map<Long, Order> orderMap;

    @Override
    public void add(Long orderID, Order order) {
        orderMap.put(orderID, order);
    }

    @Override
    public List<Order> list() {
        List<Order> orderList = new ArrayList<>();
        for(Long orderId : orderMap.keySet()){
            orderList.add(orderMap.get(orderId));
        }
        return orderList;
    }

    @Override
    public void delete(Long orderID) {
        orderMap.remove(orderID);
    }

    @Override
    public void patch(Long orderID, Order order) {
        orderMap.remove(orderID);
        orderMap.put(orderID, order);
    }

    @Override
    public Order get(Long orderID) {
        return orderMap.get(orderID);
    }
}
