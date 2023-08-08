package com.example.demo.src.domain.order;

import com.example.demo.src.domain.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
