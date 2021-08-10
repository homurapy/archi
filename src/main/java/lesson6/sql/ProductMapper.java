package lesson6.sql;

import lesson6.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {
    private final Connection connection;

    public ProductMapper(Connection connection) {
        this.connection = connection;
    }

    public Product findById(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE id = ? ");
        statement.setInt(1, id);
        {
            Product product = new Product();
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    product.setId(rs.getLong(1));
                    product.setName(rs.getString(2));
                    product.setPrice(rs.getInt(3));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return product;
        }
    }

    public boolean save(Product product) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)")) {
            connection.setAutoCommit(false);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            int row = statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            ConnectionService.rollback(connection);
            return false;
        }
    }

    public boolean update(Product product) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE products SET name = ?, price = ? WHERE id = ? ")) {
            connection.setAutoCommit(false);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setLong(3, product.getId());
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            ConnectionService.rollback(connection);
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Product product) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id = ? ")) {
            connection.setAutoCommit(false);
            statement.setLong(1, product.getId());
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            ConnectionService.rollback(connection);
            e.printStackTrace();
            return false;
        } 
    }
}

