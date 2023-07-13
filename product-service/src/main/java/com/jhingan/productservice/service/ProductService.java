package com.jhingan.productservice.service;

import com.jhingan.productservice.dto.ProductRequestDTO;
import com.jhingan.productservice.dto.ProductResponseDTO;
import com.jhingan.productservice.exception.ResourceNotFoundException;
import com.jhingan.productservice.model.Product;
import com.jhingan.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Product product = mapProductDtoToProduct(productRequestDTO);

        Product product1 = this.productRepository.save(product);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(product1.getName());
        productResponseDTO.setId(product1.getId());
        return productResponseDTO;
    }

    public List<ProductResponseDTO> getAllProducts()
    {
        List<Product> products = this.productRepository.findAll();
        return products.stream().map(product -> ProductResponseDTO
                .builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build())
                .toList();
    }

    public void deleteProduct(String id)
    {
        this.productRepository.deleteById(id);
    }

    public void updateProduct(String id, ProductRequestDTO productRequestDTO)
    {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isPresent())
        {
            Product newProduct = mapProductDtoToProduct(productRequestDTO);
            this.productRepository.save(newProduct);
        }
        else
        {
            throw new ResourceNotFoundException("Product does not exist for id: " + id);
        }
    }

    public Product mapProductDtoToProduct(ProductRequestDTO productRequestDTO)
    {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(product.getDescription());

        return product;
    }
}
