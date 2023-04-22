package com.app.items.infraestructure.clientRest;

import com.app.items.domain.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${client.rest.application.name}", url = "${client.rest.url}")
public interface ProductServiceRest {

    @GetMapping("api-product")
    ResponseEntity<List<Product>> findAll();

    @GetMapping("api-product/{id}")
    ResponseEntity<Product> findById(@PathVariable Integer id);
}
