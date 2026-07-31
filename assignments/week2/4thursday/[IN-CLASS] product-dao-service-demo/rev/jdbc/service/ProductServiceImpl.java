package com.rev.jdbc.service;

import com.rev.jdbc.dao.ProductDAO;
import com.rev.jdbc.dao.ProductDAOImpl;
import com.rev.jdbc.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {


    @Override
    public void create(Product product) {
        if (product == null || product.getId() < 0 || product.getName() == null || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Invalid product");
        }

        ProductDAO productDAO = new ProductDAOImpl();
        productDAO.create(product);
    }

    @Override
    public void update(Product product) {
        ProductDAO productDAO = new ProductDAOImpl();

        //Business logic for validation
        if (product == null || product.getName() == null || product.getName().isEmpty() || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        productDAO.update(product);
    }

    @Override
    public void delete(int id) {
        //Check that id exists in the database?
        if (id < 0) {
            throw new IllegalArgumentException("Id must be positive");
        }

        ProductDAO pd = new ProductDAOImpl();
        pd.delete(id);
    }

    @Override
    public Product findById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be positive");
        }

        ProductDAO pd = new ProductDAOImpl();
        return pd.findById(id);
    }

    @Override
    public List<Product> findAll() {
        ProductDAO pd = new ProductDAOImpl();
        return pd.findAll();
    }
}
