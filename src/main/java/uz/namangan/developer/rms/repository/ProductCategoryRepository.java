package uz.namangan.developer.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.namangan.developer.rms.model.products.Product_category;


@Repository
public interface ProductCategoryRepository extends JpaRepository<Product_category, Long> {
}
