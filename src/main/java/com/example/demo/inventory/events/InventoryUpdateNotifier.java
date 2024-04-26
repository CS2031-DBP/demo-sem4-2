package com.example.demo.inventory.events;

import com.example.demo.inventory.domain.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateNotifier {
    @Autowired
    InventoryService service;

    @EventListener
    @Async
    public void processInventoryUpdate(InventoryUpdateEvent event) {

        // TODO: Handle exceptions and notify users
        service.reduceStock(event.getProduct(), event.getQuantity());
        System.out.println("Stock updated!");

    }
}