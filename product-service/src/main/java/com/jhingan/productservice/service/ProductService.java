package com.jhingan.productservice.service;

import com.jhingan.productservice.dto.ProductRequestDTO;
import com.jhingan.productservice.dto.ProductResponseDTO;
import com.jhingan.productservice.model.Product;
import com.jhingan.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO)
    {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());

        Product product1 = this.productRepository.save(product);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(product1.getName());
        productResponseDTO.setId(product1.getId());
        return productResponseDTO;
    }

    public List<ProductResponseDTO> getAllProducts()
    {
        List<Product> products = this.productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = products.stream().map(product -> ProductResponseDTO
                .builder()
                .id(product.getId())
                .name(product.getName()).build()).toList();
        return productResponseDTOS;
    }
}
