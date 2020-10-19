package com.example.sprinbootlesson12.controller;


import com.example.sprinbootlesson12.entities.Product;
import com.example.sprinbootlesson12.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/sort")
    public Iterable<Product> getAllSortedDescendingById(){
        return productRepository.findAll(Sort.by("id").descending());

    }

    //Pagination

    @GetMapping(path = "/page/{page}")
    public List<Product> getProductsByPage(@PathVariable int page){
        return productRepository.findAll(PageRequest.of(page,3)).getContent();
    }

    @GetMapping(path = "/getByName/{name}")
    public List<Product> getProductsByName(@PathVariable String name){


        return productRepository.findProductsByName(name);
    }
}
