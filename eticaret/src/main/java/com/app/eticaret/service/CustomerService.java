package com.app.eticaret.service;

import com.app.eticaret.dto.CreateCustomerRequest;
import com.app.eticaret.dto.UpdateCustomerRequest;
import com.app.eticaret.dto.CustomerDto;
import com.app.eticaret.dto.CustomerDtoConverter;
import com.app.eticaret.exception.UserNotFoundException;
import com.app.eticaret.model.Customer;
import com.app.eticaret.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public List<CustomerDto> getAllCustomers() {

        return customerRepository.findAll().stream().map(customerDtoConverter::convert).collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User couldn't found by id: " + id));
        return customerDtoConverter.convert(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto createCustomer(CreateCustomerRequest userRequest) {

        Customer customer = new Customer(null,userRequest.getMail(), userRequest.getFirstName(),
                userRequest.getLastName());

        return customerDtoConverter.convert(customerRepository.save(customer));
    }

    public CustomerDto updateUser(Long id, UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = findUserById(id);
        customer.setMail(updateCustomerRequest.getMail());
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());

        return customerDtoConverter.convert(customerRepository.save(customer));
    }

    private Customer findUserById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User couldn't found by following id:" + id));

    }


}
