package com.github.listdynamictable;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Product {
    @NotNull(message = "ID can not null")
    @Min(value = 1, message = "Minimum 1")
    private Integer id;

    @NotBlank(message = "Name can not blank")
    @Size(min = 5, max = 50, message = "Name character must between 5 to 50")
    private String name;

    @NotNull(message = "Quantity can not null")
    @Min(value = 1, message = "Minimum quantity 1")
    @Max(value = 50, message = "Maximum order 50")
    private Integer quantity;

    @NotNull(message = "Price can not null")
    @Min(value = 10, message = "price at least 10")
    private Double price;
}
