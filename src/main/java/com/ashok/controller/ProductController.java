package com.ashok.controller;

import com.ashok.entity.Product;
import com.ashok.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product prodSaved = productService.saveProduct(product);
        return new ResponseEntity<Product>(prodSaved, HttpStatus.CREATED);
    }

    @PostMapping("/addProducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        List<Product> productsSaved = productService.saveProducts(products);
        return new ResponseEntity<List<Product>>(productsSaved, HttpStatus.CREATED);
    }

    @GetMapping("/productName/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) throws Exception {
        Product prodRertived = productService.getProductByName(name);
        return new ResponseEntity<Product>(prodRertived, HttpStatus.OK);
    }


    @GetMapping("/productId/{id}")
    public ResponseEntity<Product> getProductByid(@PathVariable int id) {
        Product prodRertived = productService.getProductById(id);
        return new ResponseEntity<Product>(prodRertived, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> listOfAllProds = productService.getProducts();
        return new ResponseEntity<>(listOfAllProds, HttpStatus.OK);
    }


    @PutMapping("/updateProduct")
    public ResponseEntity<Product> getProductByid(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteByid(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }


}
