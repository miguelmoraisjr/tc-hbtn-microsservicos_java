package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(value = "API Rest Products")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ApiOperation(value = "- Responsável por retornar uma mensagem de boas vindas", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbbiden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping("/welcome")
    public ResponseEntity<String> mensagemBoasVindas() {
        return ResponseEntity.ok().body("BEM VINDO À PRODUCT REST API.");
    }

    @ApiOperation(value = "- Responsável por retornar uma lista de produtos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbbiden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> produtos() {
        List<Product> products = productRepository.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @ApiOperation(value = "- Responsável por retornar um produto pelo id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbbiden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    @GetMapping("/findProductById/{id}")
    public ResponseEntity<Product> produtoPorId(@PathVariable Integer id) {
        Product product = productRepository.getProductById(id);
        return ResponseEntity.ok().body(product);
    }

    @ApiOperation(value = "- Responsável por adicionar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbbiden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 10, message = "Required fields not informed.")

    })
    @PostMapping("/addProduct")
    @ResponseStatus(value = HttpStatus.OK)
    public void addProduto(@RequestBody Product product) {
        productRepository.addProduct(product);
    }


    @ApiOperation(value = "- Responsável por atualizar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbbiden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    @PutMapping("/updateProduct")
    @ResponseStatus(value = HttpStatus.OK)
    public void atualizarProduto(@RequestBody Product product) {
        productRepository.updateProduct(product);
    }

    @ApiOperation(value = "- Responsável por remover um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbbiden"),
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    @DeleteMapping("/removeProduct")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProduto(@RequestBody Product product) {
        productRepository.removeProduct(product);
    }








}
