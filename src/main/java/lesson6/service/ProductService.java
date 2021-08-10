package lesson6.service;

import lesson6.model.Product;
import lesson6.repository.ProductRepository;
import lesson6.repository.Registry;
import lesson6.sql.ConnectionService;
import lesson6.sql.ProductMapper;

import java.sql.SQLException;

public class ProductService {
    private Registry registry;

    public ProductService(Registry registry) {
        this.registry = Registry.getInstance();
    }

    public Product findById(Long id) throws SQLException {
        ProductMapper mapper = new ProductMapper(ConnectionService.connectSQLite());
        ProductRepository productRepository = registry.getProductRepository();
        Product product = productRepository.getProduct(id);
        if (product == null) {
            product = mapper.findById(Math.toIntExact(id));
            productRepository.addProduct(product);
            return product;
        }
        return product;
    }
}
