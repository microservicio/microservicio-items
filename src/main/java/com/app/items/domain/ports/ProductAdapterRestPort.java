package com.app.items.domain.ports;

import com.app.items.domain.models.Item;
import com.app.items.domain.models.Product;

import java.util.List;

public interface ProductAdapterRestPort {
    List<Product> findAllProducts();
    Product findById(Integer id);
}
