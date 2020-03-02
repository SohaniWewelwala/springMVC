package com.example.spring.springmvc.controllers;

import com.example.spring.springmvc.model.ApiResponse;
import com.example.spring.springmvc.model.Customer;
import com.example.spring.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Customer> getAllCustomers() {
        return customerService.listAllCustomers();
    }

    @RequestMapping(value = "/customers/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/customer/new", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ApiResponse createNewCustomer(Customer customer){
        return customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/customers/delete/{id}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ApiResponse deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }

}
