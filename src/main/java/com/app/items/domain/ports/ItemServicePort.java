package com.app.items.domain.ports;

import com.app.items.domain.models.Item;
import com.app.items.domain.models.Product;

import java.util.List;

public interface ItemServicePort {
    List<Item> findAll();
    Item findById(Integer id, Integer cantidad);

    Product save(Product product);

    Product update(Product product);
    void deleteProduct(Integer id);
}
