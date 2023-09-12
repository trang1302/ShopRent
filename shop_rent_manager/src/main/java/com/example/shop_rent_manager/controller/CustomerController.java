package com.example.shop_rent_manager.controller;
import com.example.shop_rent_manager.model.Customer;
import com.example.shop_rent_manager.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/customers")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        try {
            Customer savedCustomer = customerService.createCustomer(customer);
            return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long customerId){
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long customerId,
                                           @RequestBody Customer customer){
        customer.setId(customerId);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer successfully deleted!", HttpStatus.OK);
    }
}