package com.app.items.domain.models;

import com.app.commons.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private Product product;
    private Integer cantidad;
}
