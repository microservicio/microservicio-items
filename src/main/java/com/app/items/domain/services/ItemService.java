package com.app.items.domain.services;

import com.app.items.domain.models.Item;
import com.app.items.domain.models.Product;
import com.app.items.domain.ports.ItemServicePort;
import com.app.items.domain.ports.ProductAdapterRestPort;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ItemService implements ItemServicePort {

    private final ProductAdapterRestPort productAdapterRestPort;

    public ItemService(ProductAdapterRestPort productAdapterRestPort) {
        this.productAdapterRestPort = productAdapterRestPort;
    }

    public List<Item> findAll() {
        return productAdapterRestPort.findAllProducts()
                .stream().map(convert())
                .toList();
    }

    @Override
    public Item findById(Integer id, Integer cantidad) {
        var product = productAdapterRestPort.findById(id);
        return new Item(product, cantidad);
    }

    @Override
    public Product save(Product product) {
        return productAdapterRestPort.save(product);
    }

    @Override
    public Product update(Product product) {
        var oldProduct = productAdapterRestPort.findById(product.getId());
        oldProduct.setNombre(product.getNombre());
        oldProduct.setPrecio(product.getPrecio());
        return productAdapterRestPort.update(oldProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
      productAdapterRestPort.deleteProductById(id);
    }

    private Function<Product, Item> convert() {
        return product -> new Item(product, 1);
    }
}
