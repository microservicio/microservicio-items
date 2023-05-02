package com.app.items.infraestructure.adapter;

import com.app.items.domain.models.Product;
import com.app.items.domain.ports.ProductAdapterRestPort;
import com.app.items.infraestructure.clientRest.ProductServiceRest;
import feign.FeignException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductAdapterRest implements ProductAdapterRestPort {

    private final ProductServiceRest productServiceRest;

    public ProductAdapterRest(ProductServiceRest productServiceRest) {
        this.productServiceRest = productServiceRest;
    }

    @Override
    public List<Product> findAllProducts() {
        try {
            return productServiceRest.findAll().getBody();
        } catch (FeignException.FeignClientException feignClientException) {
            throw new RuntimeException(feignClientException.getMessage());
        }
    }

    @Override
    public Product findById(Integer id) {
        try {
            return productServiceRest.findById(id).getBody();
        } catch (FeignException.FeignClientException feignClientException) {
            throw new RuntimeException(feignClientException.getMessage());
        }
    }

    @Override
    public void deleteProductById(Integer id) {
        try {
            productServiceRest.deleteProduct(id);
        } catch (FeignException.FeignClientException feignClientException) {
            throw new RuntimeException(feignClientException.getMessage());
        }
    }

    @Override
    public Product save(Product product) {
        try {
           return productServiceRest.save(product).getBody();
        } catch (FeignException.FeignClientException feignClientException) {
            throw new RuntimeException(feignClientException.getMessage());
        }
    }

    @Override
    public Product update(Product product) {
        try {
            return productServiceRest.update(product).getBody();
        } catch (FeignException.FeignClientException feignClientException) {
            throw new RuntimeException(feignClientException.getMessage());
        }
    }

}
