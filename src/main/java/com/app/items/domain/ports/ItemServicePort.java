package com.app.items.domain.ports;

import com.app.commons.models.Product;
import com.app.items.domain.models.Item;

import java.util.List;

public interface ItemServicePort {
    List<Item> findAll();
    Item findById(Integer id, Integer cantidad);

    Product save(Product product);

    Product update(Product product);
    void deleteProduct(Integer id);
}
