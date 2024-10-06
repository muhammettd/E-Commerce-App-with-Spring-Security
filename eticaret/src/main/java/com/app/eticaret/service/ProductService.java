package com.app.eticaret.service;

import com.app.eticaret.dto.AddProduct;
import com.app.eticaret.dto.ProductDto;
import com.app.eticaret.dto.ProductDtoConverter;
import com.app.eticaret.model.Product;
import com.app.eticaret.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;

    public ProductService(ProductRepository productRepository, ProductDtoConverter productDtoConverter) {
        this.productRepository = productRepository;
        this.productDtoConverter = productDtoConverter;
    }

    public List<ProductDto> getAllProducts() {

        return productRepository.findAll().stream().map(productDtoConverter::convert).collect(Collectors.toList());

    }

    public ProductDto addProduct(AddProduct newProduct) {

        Product product = new Product(null,newProduct.getName(), newProduct.getPrice(), newProduct.getCategory());

        return productDtoConverter.convert(productRepository.save(product));

    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
