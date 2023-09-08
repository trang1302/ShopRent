package com.example.shop_rent_manager.impl;

import com.example.shop_rent_manager.model.Customer;
import com.example.shop_rent_manager.repository.CustomerRepository;
import com.example.shop_rent_manager.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).get();
        existingCustomer.setName(customer.getName());
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return updatedCustomer;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}