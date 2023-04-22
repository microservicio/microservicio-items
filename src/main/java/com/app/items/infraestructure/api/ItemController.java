package com.app.items.infraestructure.api;

import com.app.items.domain.models.Item;
import com.app.items.domain.ports.ItemServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api-items")
public class ItemController {

    private final ItemServicePort itemServicePort;

    public ItemController(ItemServicePort itemServicePort) {
        this.itemServicePort = itemServicePort;
    }

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        var items = itemServicePort.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}/{cantidad}")
    public ResponseEntity<Item> findById(@PathVariable Integer id, @PathVariable Integer cantidad){
        var item = itemServicePort.findById(id,cantidad);
        return ResponseEntity.ok(item);
    }
}
