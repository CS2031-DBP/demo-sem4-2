package com.example.demo.orderdetail.domain;

import com.example.demo.inventory.domain.InventoryService;
import com.example.demo.orderdetail.infrastructure.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository repository;

    @Autowired
    InventoryService inventoryService;

    public List<OrderDetail> list() {
        return repository.findAll();
    }

    public void save(OrderDetail orderDetail) {
        repository.save(orderDetail);

        // TODO: Reduce Inventory through Events
        inventoryService.reduceStock(orderDetail.getProduct(), orderDetail.getQuantity());
    }
}
