package com.ashok.service;

import com.ashok.entity.Product;
import com.ashok.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product){
        return  productRepository.save(product);
    }


    public List<Product> saveProducts(List<Product> products){
        return  productRepository.saveAll(products);
    }

    public List<Product> getProducts(){

        return productRepository.findAll();
    }

    public Product getProductById(int  id){

        return productRepository.findById(id).get();
    }

    public Product getProductByName(String name ) throws Exception {
       Product product= productRepository.findByName(name);
       if(product==null)
           throw new Exception("Not found");
        return productRepository.findByName(name);
    }

    public void deleteProduct(int id){

        productRepository.deleteById(id);
    }


    public Product updateProduct(Product product){
        Product exisitingProduct= productRepository.findById(product.getId()).orElse(null);
        exisitingProduct.setName(product.getName());
        exisitingProduct.setPrice(product.getPrice());
        exisitingProduct.setQuantity(product.getQuantity());
        return productRepository.save(exisitingProduct);
    }


}
