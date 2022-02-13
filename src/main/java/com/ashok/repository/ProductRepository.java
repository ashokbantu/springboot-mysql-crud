package com.ashok.repository;

import com.ashok.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Product findByName(String name);
}
