package com.java.l7;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Product {
    @NotNull(message = "Id can not null")
    private long id;
    @NotBlank(message="product name can not blank")
    private String productName;
    @NotBlank(message = "Product description can not blank")
    private String productDescription;
}
