package com.example.demo.orderdetail.application;

import com.example.demo.orderdetail.domain.OrderDetail;
import com.example.demo.orderdetail.domain.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/detail")
public class OrderDetailController {
    @Autowired
    OrderDetailService service;

    @GetMapping
    ResponseEntity<List<OrderDetail>> list() {
        return ResponseEntity.ok(service.list());
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody OrderDetail orderDetail) {
        service.save(orderDetail);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // TODO: Exceptions and DTOs
}
