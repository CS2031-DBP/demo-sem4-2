package com.example.demo.inventory.domain;

import com.example.demo.inventory.infrastructure.InventoryRepository;
import com.example.demo.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository repository;

    public List<Inventory> list() {
        return repository.findAll();
    }

    public void save(Inventory inventory) {
        repository.save(inventory);
    }

    @Async
    public void reduceStock(Product product, Integer quantity) {
        Inventory inventory = repository.findByProductId(product.getId());

        // TODO: Handle exceptions
        inventory.setStock(inventory.getStock() - quantity);

        repository.save(inventory);
    }
}
