package uz.namangan.developer.rms.service;

import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.model.products.Product_category;
import uz.namangan.developer.rms.repository.ProductCategoryRepository;


import java.util.List;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public Product_category create(Product_category product_category){
        return productCategoryRepository.save(product_category);
    }

    public List<Product_category> findAll(){
        return productCategoryRepository.findAll();
    }

    public Product_category findById(long id){
        return productCategoryRepository.findById(id).get();
    }

    public void delete(Long id){
        Product_category product_category = productCategoryRepository.getOne(id);
        productCategoryRepository.delete(product_category);
    }

    public void deleteAll(){
        productCategoryRepository.deleteAll();
    }

    public void update(Product_category product_category){
        productCategoryRepository.save(product_category);
    }
}
