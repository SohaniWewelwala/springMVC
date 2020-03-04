package com.example.spring.springmvc.bootstrap;

import com.example.spring.springmvc.model.Customer;
import com.example.spring.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringJPACustomer implements ApplicationListener<ContextRefreshedEvent> {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadCustomers();
    }

    private void loadCustomers(){

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Sonic");
        customer1.setLastName("Wewel");
        customer1.setEmail("soni@gmail.com");
        customer1.setAddress("galle");
        customer1.setPhoneNo("0912345567");
        customerService.createCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Sonic2");
        customer2.setLastName("Wewel2");
        customer2.setEmail("soni@gmail2.com");
        customer2.setAddress("galle2");
        customer2.setPhoneNo("09123455672");
        customerService.createCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Sonic3");
        customer3.setLastName("Wewel3");
        customer3.setEmail("soni@gmail3.com");
        customer3.setAddress("galle3");
        customer3.setPhoneNo("09123455673");
        customerService.createCustomer(customer3);

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setFirstName("Sonic4");
        customer4.setLastName("Wewel4");
        customer4.setEmail("soni@gmail4.com");
        customer4.setAddress("galle4");
        customer4.setPhoneNo("09123455674");
        customerService.createCustomer(customer4);
    }
}
