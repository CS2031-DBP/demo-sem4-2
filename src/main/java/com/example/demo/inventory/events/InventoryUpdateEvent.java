package com.example.demo.inventory.events;

import com.example.demo.product.domain.Product;
import org.springframework.context.ApplicationEvent;

public class InventoryUpdateEvent extends ApplicationEvent {
    private final Product product;
    private final Integer quantity;

    public InventoryUpdateEvent(Object source, Product product, Integer quantity) {
        super(source);
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }
}