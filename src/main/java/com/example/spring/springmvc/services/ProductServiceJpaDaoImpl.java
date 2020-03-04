package com.example.spring.springmvc.services;

import com.example.spring.springmvc.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl implements ProductService {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Product> listAllProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getProductById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product updateProduct(Product product) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Product saveProduct=entityManager.merge(product);
        entityManager.getTransaction().commit();
        return saveProduct;
    }

    @Override
    public void deleteProduct(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Product.class,id));
        entityManager.getTransaction().commit();

    }
}
