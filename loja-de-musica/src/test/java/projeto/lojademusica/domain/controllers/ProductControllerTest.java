//package projeto.lojademusica.domain.controllers;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import projeto.lojademusica.domain.entities.Product;
//import projeto.lojademusica.domain.services.ProductServices;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ProductController.class)
//class ProductControllerTest {
//
//    @Autowired private MockMvc mockMvc;
//
//    @MockBean
//    private ProductServices productServices;
//
//
//    private
//    @Test
//    void findById() {
//    }
//
//    @Test
//    void findAll() {
//    }
//
//    @Test
//    void save() {
//        Product product = new Product(1L, "TV", 2000.00, 34);
//
//        when(productServices.save(any())).thenReturn(product);
//
//
//
//    }
//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }
//}