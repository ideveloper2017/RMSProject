package uz.namangan.developer.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.namangan.developer.rms.model.products.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
