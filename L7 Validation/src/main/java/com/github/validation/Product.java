package com.github.validation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Product {
    @NotNull(message = "Product id must be provided")
    private int id;
    @NotBlank(message = "Product name can not blank")
    private String name;
    @NotNull(message = "Product quantity must be provided")
    @Min(value = 1, message = "Product quantity must be grater than 0")
    private int quantity;
}
