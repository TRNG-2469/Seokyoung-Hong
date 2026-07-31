package com.rev.jdbc.service;

import com.rev.jdbc.model.Product;

import java.util.List;

public interface ProductService {

    void create(Product product);
    void update(Product product);
    void delete(int id);

    //Read ALL, Read one
    Product findById(int id);
    List<Product> findAll();
}
