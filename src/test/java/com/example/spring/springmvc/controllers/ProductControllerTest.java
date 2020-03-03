package com.example.spring.springmvc.controllers;

import com.example.spring.springmvc.model.Product;
import com.example.spring.springmvc.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest {

    @Mock //Mockito mock object
    private ProductService productService;

    @InjectMocks //set up controller and inject mock objects into it
    private ProductController productController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); //initialize controller and mocks
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void TestList() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        //specific Mockito interaction, tell stub to return list of products
        when(productService.listAllProducts()).thenReturn((List) products);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("/products"))
                .andExpect(model().attribute("products", hasSize(2)));
    }

//    public void TestView()throws Exception{
//        int id=1;
//
//        when(ProductService.getProductById(id)).thenReturn(new Product());
//
//        mockMvc.perform(get("/product/1"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("product"))
//                .andExpect(model().attribute("product", instanceOf(Product.class)));
//    }
}
