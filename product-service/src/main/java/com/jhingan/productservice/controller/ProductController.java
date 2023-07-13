package com.jhingan.productservice.controller;

import com.jhingan.productservice.dto.ProductRequestDTO;
import com.jhingan.productservice.dto.ProductResponseDTO;
import com.jhingan.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        ProductResponseDTO productResponseDTO = this.productService.createProduct(productRequestDTO);
        return String.format("Product with id %s and name %s has been created",productResponseDTO.getId(), productResponseDTO.getName());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDTO> getAllProducts()
    {
        return this.productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id)
    {
        this.productService.deleteProduct(id);
    }
}
