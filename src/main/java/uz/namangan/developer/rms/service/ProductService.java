package uz.namangan.developer.rms.service;

import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.model.products.Product;
import uz.namangan.developer.rms.repository.ProductRepository;


import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(long id){
        return productRepository.findById(id).get();
    }

    public void delete(Long id){
        Product product = productRepository.getOne(id);
        productRepository.delete(product);
    }

    public void deleteAll(){
        productRepository.deleteAll();
    }

    public void update(Product product){
        productRepository.save(product);
    }
}
