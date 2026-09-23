package com.github.listdynamictable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Product_table")
public class Product {
    @Id
    @NotNull(message = "ID can not null")
    @Min(value = 1, message = "Minimum 1")
    private Integer id;

    @NotBlank(message = "Name can not blank")
    @Size(min = 5, max = 50, message = "Name character must between 5 to 50")
    @Column(name = "Product_name")
    private String name;

    @NotNull(message = "Quantity can not null")
    @Min(value = 1, message = "Minimum quantity 1")
    @Max(value = 50, message = "Maximum order 50")
    private Integer quantity;

    @NotNull(message = "Price can not null")
    @Min(value = 10, message = "price at least 10")
    private Double price;
}
