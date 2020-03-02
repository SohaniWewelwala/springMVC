package com.example.spring.springmvc.services;

import com.example.spring.springmvc.model.ApiResponse;
import com.example.spring.springmvc.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer getCustomerById(int id);

    ApiResponse createCustomer(Customer customer);

    ApiResponse deleteCustomer(int id);


}
