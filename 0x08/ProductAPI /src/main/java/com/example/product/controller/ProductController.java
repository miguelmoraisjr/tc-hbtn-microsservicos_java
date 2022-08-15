package com.example.product.controller;

import com.example.product.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/welcome")
    public ResponseEntity<String> mensagemBoasVindas() {
        return ResponseEntity.ok().body("BEM VINDO À PRODUCT REST API.");
    }




}
