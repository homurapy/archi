package lesson7.Utils;

import lesson7.dto.ProductDto;
import lesson7.model.Product;

public class Mapping {
    public static ProductDto productToDto(Product product){
        ProductDto dto = new ProductDto(product.getId(), product.getName(), product.getPrice());
        return dto;
    }
    public static Product dtoToProduct(ProductDto dto) {
        Product product = new Product(dto.getId(), dto.getName(), dto.getPrice());
        return product;
    }
    }
