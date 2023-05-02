package com.app.items.infraestructure.clientRest;

import com.app.items.domain.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "${client.rest.application.name}")
public interface ProductServiceRest {

    @GetMapping("api-product")
    ResponseEntity<List<Product>> findAll();

    @GetMapping("api-product/{id}")
    ResponseEntity<Product> findById(@PathVariable Integer id);
    @DeleteMapping("api-product/eliminar")
    ResponseEntity<Void> deleteProduct(@RequestParam Integer id);

    @PostMapping("api-product")
    ResponseEntity<Product> save(@RequestBody Product productDTO);

    @PutMapping("api-product")
    ResponseEntity<Product> update(@RequestBody Product productDTO);

}
