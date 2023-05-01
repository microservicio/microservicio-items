package com.app.items.infraestructure.api;

import com.app.items.domain.models.Item;
import com.app.items.domain.ports.ItemServicePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api-items")
public class ItemController {

    private final ItemServicePort itemServicePort;

    @Value("${configuracion.texto}")
    private String texto;

    public ItemController(ItemServicePort itemServicePort) {
        this.itemServicePort = itemServicePort;
    }

    @GetMapping(value = "obtener-configuracion/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getConfiguration(@Value("$[server.port}") String port) {
        log.info(texto);
        var response = new HashMap<String, String>();
        response.put("texto", texto);
        response.put("puerto", port);
        return ResponseEntity.ok(response);
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
