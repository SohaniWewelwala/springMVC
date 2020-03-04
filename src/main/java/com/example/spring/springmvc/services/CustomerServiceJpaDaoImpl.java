package com.example.spring.springmvc.services;

import com.example.spring.springmvc.model.ApiResponse;
import com.example.spring.springmvc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl implements CustomerService{

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public List<Customer> listAllCustomers() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Customer",Customer.class).getResultList();
    }

    @Override
    public Customer getCustomerById(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return entityManager.find(Customer.class,id);
    }

    @Override
    public ApiResponse createCustomer(Customer customer) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer saveCustomer=entityManager.merge(customer);
        entityManager.getTransaction().commit();
        return null;
    }

    @Override
    public ApiResponse deleteCustomer(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Customer.class,id));
        entityManager.getTransaction().commit();
        return null;
    }
}
