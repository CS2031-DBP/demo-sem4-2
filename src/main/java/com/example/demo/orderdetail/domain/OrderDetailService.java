package com.example.demo.orderdetail.domain;

import com.example.demo.inventory.domain.InventoryService;
import com.example.demo.inventory.events.InventoryUpdateEvent;
import com.example.demo.orderdetail.infrastructure.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

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
        publisher.publishEvent(new InventoryUpdateEvent(this, orderDetail.getProduct(), orderDetail.getQuantity()));
    }
}
