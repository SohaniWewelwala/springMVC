package com.example.spring.springmvc.services;

import com.example.spring.springmvc.model.ApiResponse;
import com.example.spring.springmvc.model.Customer;
import com.example.spring.springmvc.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    @Override
    public ApiResponse createCustomer(Customer customer) {
        ApiResponse apiresponse =new ApiResponse();
        if (customer != null) {
            if (customer.getId() != 0) {
                customer.setId(getNextKey());
            }
            customers.put(5,customer);
            apiresponse.setStatusCode(200);
            apiresponse.setData("Success");
            apiresponse.setMessage("Successfully created a customer");
            return apiresponse;
        }else {
            apiresponse.setStatusCode(400);
            apiresponse.setData("Fail");
            apiresponse.setMessage("Failed to create a customer");
            return apiresponse;
        }
    }

    private int getNextKey() {
        return Collections.max(customers.keySet()) + 1;
    }

    @Override
    public ApiResponse deleteCustomer(int id) {
        ApiResponse apiResponse=new ApiResponse();
        if(customers.get(id)!=null){
            customers.remove(id);
            if(customers.get(id)==null){
                apiResponse.setStatusCode(200);
                apiResponse.setData("Success");
                apiResponse.setMessage("Successfully deleted");

            }else{
                apiResponse.setStatusCode(400);
                apiResponse.setData("Fail");
                apiResponse.setMessage("Couldn't delete the customer");
            }
            return apiResponse;
        }else{
            apiResponse.setStatusCode(400);
            apiResponse.setData("Fail");
            apiResponse.setMessage("Couldn't delete the customer");
            return apiResponse;
        }
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Sonic");
        customer1.setLastName("Wewel");
        customer1.setEmail("soni@gmail.com");
        customer1.setAddress("galle");
        customer1.setPhoneNo("0912345567");
        customers.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Sonic2");
        customer2.setLastName("Wewel2");
        customer2.setEmail("soni@gmail2.com");
        customer2.setAddress("galle2");
        customer2.setPhoneNo("09123455672");
        customers.put(2, customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Sonic3");
        customer3.setLastName("Wewel3");
        customer3.setEmail("soni@gmail3.com");
        customer3.setAddress("galle3");
        customer3.setPhoneNo("09123455673");
        customers.put(3, customer3);

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setFirstName("Sonic4");
        customer4.setLastName("Wewel4");
        customer4.setEmail("soni@gmail4.com");
        customer4.setAddress("galle4");
        customer4.setPhoneNo("09123455674");
        customers.put(4, customer4);
    }
}
