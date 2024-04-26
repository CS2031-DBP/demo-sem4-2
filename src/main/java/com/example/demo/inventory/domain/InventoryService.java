package com.example.demo.inventory.domain;

import com.example.demo.inventory.infrastructure.InventoryRepository;
import com.example.demo.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository repository;

    private final Logger logger = LoggerFactory.getLogger(InventoryService.class);

    public List<Inventory> list() {
        return repository.findAll();
    }

    public void save(Inventory inventory) {
        repository.save(inventory);
    }

    public void heavyProcess(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception exception) {
            logger.error("Ocurrió un problema con el thread secundario: " + exception.getMessage());
        }
    }

//    @Async
    public void reduceStock(Product product, Integer quantity) {
        Inventory inventory = repository.findByProductId(product.getId());

        heavyProcess(10000L);
        // TODO: Handle exceptions
        inventory.setStock(inventory.getStock() - quantity);


        repository.save(inventory);
    }
}
