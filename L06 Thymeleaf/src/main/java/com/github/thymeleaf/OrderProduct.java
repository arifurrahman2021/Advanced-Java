package com.github.thymeleaf;

import lombok.Data;

@Data
public class OrderProduct {
    private String productName;
    private String quantity;
    private String deliveryAddress;
}
