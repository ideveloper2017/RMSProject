package uz.namangan.developer.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.namangan.developer.rms.model.food.FoodCategory;


@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory,Long> {

}
