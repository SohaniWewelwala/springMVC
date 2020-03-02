package com.example.spring.springmvc.services;

import com.example.spring.springmvc.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(int id);

    Product updateProduct(Product product);

    void deleteProduct(int id);
}
