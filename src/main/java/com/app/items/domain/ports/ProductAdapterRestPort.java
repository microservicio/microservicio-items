package com.app.items.domain.ports;

import com.app.commons.models.Product;

import java.util.List;

public interface ProductAdapterRestPort {
    List<Product> findAllProducts();
    Product findById(Integer id);

    void deleteProductById(Integer id);

    Product save(Product product);

    Product update (Product product);
}
