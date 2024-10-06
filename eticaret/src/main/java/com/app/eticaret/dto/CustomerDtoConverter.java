package com.app.eticaret.dto;

import com.app.eticaret.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public CustomerDto convert(Customer from) {
        return new CustomerDto(from.getId(), from.getMail(), from.getFirstName(),
                from.getLastName());
    }

}
