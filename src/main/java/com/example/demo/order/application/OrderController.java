package com.example.demo.order.application;

import com.example.demo.order.domain.Order;
import com.example.demo.order.domain.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService service;

    @GetMapping
    ResponseEntity<List<Order>> list() {
        return ResponseEntity.ok(service.list());
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody Order order) {
        service.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
