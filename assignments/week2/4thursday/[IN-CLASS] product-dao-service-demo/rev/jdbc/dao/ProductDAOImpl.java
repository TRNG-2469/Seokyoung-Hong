package com.rev.jdbc.dao;

import com.rev.jdbc.model.Product;
import com.rev.utils.ConnectionFactory;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void create(Product product) {
        String createSQL = "INSERT INTO product(product_id, name, price) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(createSQL);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        String updateSQL = "UPDATE product SET name=?, price=? WHERE product_id=?";
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String deleteQuery = "DELETE FROM product WHERE product_id = ?";
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        String selectQuery = "SELECT * FROM product WHERE product_id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(selectQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int p_id = rs.getInt("product_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                return new Product(p_id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Product> findAll() {
        String selectQuery = "SELECT * FROM product";

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            List<Product> productList = new ArrayList<>();

            while (rs.next()) {
                int p_id = rs.getInt("product_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                Product p = new Product(p_id, name, price);
                productList.add(p);
            }

            return productList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
