package com.app.eticaret.dto;


import com.app.eticaret.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {

    public ProductDto convert(Product pfrom) {

        return new ProductDto(pfrom.getId(),pfrom.getName(), pfrom.getPrice(), pfrom.getCategory());
    }

}
