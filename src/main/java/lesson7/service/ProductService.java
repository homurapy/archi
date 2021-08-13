package lesson7.service;

import lesson7.Utils.Mapping;
import lesson7.dto.ProductDto;
import lesson7.model.Product;
import lesson7.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDto> findAll(){
        return productRepository.findAll().stream().map(Mapping::productToDto).collect(Collectors.toList());
    }
    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }
    public  void deleteById(Long id){
        productRepository.deleteById(id);
    }
    public Product save(ProductDto dto){
        return productRepository.save(Mapping.dtoToProduct(dto));
    }
}
