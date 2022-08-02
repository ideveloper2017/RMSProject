package uz.namangan.developer.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.namangan.developer.rms.model.food.FoodItem;


@Repository
public interface FoodRepository extends JpaRepository<FoodItem, Long> {

}
