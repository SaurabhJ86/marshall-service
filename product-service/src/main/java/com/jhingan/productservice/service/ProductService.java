package com.jhingan.productservice.service;

import com.jhingan.productservice.dto.ProductRequestDTO;
import com.jhingan.productservice.model.Product;
import com.jhingan.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequestDTO productRequestDTO)
    {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());

        this.productRepository.save(product);
    }
}
