package com.example.demo.order.domain;

import com.example.demo.order.infrastructure.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRespository respository;

    public List<Order> list() {
        return respository.findAll();
    }

    public void save(Order order) {
        respository.save(order);
    }
}
