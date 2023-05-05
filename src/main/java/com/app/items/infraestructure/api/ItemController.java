package com.app.items.infraestructure.api;

import com.app.commons.models.Product;
import com.app.items.domain.models.Item;
import com.app.items.domain.ports.ItemServicePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api-items")
public class ItemController {

    private final ItemServicePort itemServicePort;
    private final Environment environment;
    private static final String PROFILE_DEV = "dev";

    @Value("${configuracion.texto}")
    private String texto;

    public ItemController(ItemServicePort itemServicePort, Environment environment) {
        this.itemServicePort = itemServicePort;
        this.environment = environment;
    }

    @GetMapping(value = "obtener-configuracion/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getConfiguration(@Value("${server.port}") String port) {
        log.info(texto);
        var response = new HashMap<String, String>();

        if (isProfileDev()) {
            response.put("autor", environment.getProperty("configuracion.autor"));
            response.put("correo", environment.getProperty("configuracion.email"));
        }
        response.put("texto", texto);
        response.put("puerto", port);
        return ResponseEntity.ok(response);
    }

    private boolean isProfileDev() {
        return this.environment.getActiveProfiles().length > 0
                && PROFILE_DEV.equals(this.environment.getActiveProfiles()[0]);
    }

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        var items = itemServicePort.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}/{cantidad}")
    public ResponseEntity<Item> findById(@PathVariable Integer id, @PathVariable Integer cantidad) {
        var item = itemServicePort.findById(id, cantidad);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        var response = itemServicePort.save(product);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        var response = itemServicePort.update(product);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<Void> findById(@PathVariable Integer id) {
        itemServicePort.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
