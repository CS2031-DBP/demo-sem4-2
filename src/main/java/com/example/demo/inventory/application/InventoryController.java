package com.example.demo.inventory.application;

import com.example.demo.inventory.domain.Inventory;
import com.example.demo.inventory.domain.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService service;

    @GetMapping
    public ResponseEntity<List<Inventory>> list() {
        return ResponseEntity.ok(service.list());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Inventory inventory) {
        service.save(inventory);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
