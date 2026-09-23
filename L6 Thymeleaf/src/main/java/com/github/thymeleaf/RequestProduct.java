package com.github.thymeleaf;

import lombok.Data;

@Data
public class RequestProduct {
    private String requestedProductName;
    private Integer requestedProductQuantity;
    private String requestedProductDescription;

}
