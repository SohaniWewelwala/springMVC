package com.example.spring.springmvc.services;

import com.example.spring.springmvc.config.JpaIntegrationConfig;
import com.example.spring.springmvc.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.boot.test.SpringApplicationConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class ProductServiceJapDaoImplTest {

//    private ProductService productService;
//
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @Test
//    public void TestListMethod() throws Exception{
//        List<Product> products=(List<Product>) productService.listAllProducts();
//
//        assert products.size()==5;
//    }


}
