package com.jhingan.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequestDTO {

    private String id;
    private String description;
    private String name;
    private BigDecimal price;
}
