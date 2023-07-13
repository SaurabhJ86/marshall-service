package com.jhingan.productservice.controller;

import com.jhingan.productservice.dto.ProductRequestDTO;
import com.jhingan.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        this.productService.createProduct(productRequestDTO);
        return "Product has been created";
    }
}
