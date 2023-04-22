package com.app.items.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Product {
    private Integer id;
    private String nombre;
    private Double precio;
    private LocalDateTime createAt;
}
