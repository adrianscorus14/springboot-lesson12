package com.example.sprinbootlesson12.repository;


import com.example.sprinbootlesson12.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {


    List<Product> findProductsByName(String name);
    //we can also add a Sort object as a parameter
}
