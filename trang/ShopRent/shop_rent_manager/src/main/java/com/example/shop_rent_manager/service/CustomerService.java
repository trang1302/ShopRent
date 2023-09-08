package com.example.shop_rent_manager.service;

import com.example.shop_rent_manager.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(Long customerId);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long customerId);
}