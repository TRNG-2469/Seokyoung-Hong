package com.rev.utils;

import com.rev.jdbc.dao.ProductDAO;
import com.rev.jdbc.dao.ProductDAOImpl;
import com.rev.jdbc.model.Product;
import com.rev.jdbc.service.ProductService;
import com.rev.jdbc.service.ProductServiceImpl;


public class MainClass {
    public static void main(String[] args) {

        // Main --> Service --> DAO ---> Database
        ProductService service = new ProductServiceImpl();

        //Create Call
        /*Product product = new Product(6, "New Product", 2221);
        service.create(product);

        //Update Call
        Product product = new Product(3, "Changed Product", 1111111);
        service.update(product);

        //Delete Call
        int productId = 6;
        service.delete(productId);

        //Find by id
        int productId = 1;
        System.out.println(service.findById(productId)); */

        //Findall
        System.out.println(service.findAll());

    }

}
