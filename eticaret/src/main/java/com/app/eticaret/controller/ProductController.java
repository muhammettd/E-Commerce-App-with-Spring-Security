package com.app.eticaret.controller;

import com.app.eticaret.dto.AddProduct;
import com.app.eticaret.dto.ProductDto;
import com.app.eticaret.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public ResponseEntity<List<ProductDto>> gelAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    ResponseEntity<ProductDto> addProduct(@RequestBody AddProduct newProduct) {
        return ResponseEntity.ok(productService.addProduct(newProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
