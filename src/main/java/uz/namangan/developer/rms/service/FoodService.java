package uz.namangan.developer.rms.service;

import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.model.food.FoodItem;
import uz.namangan.developer.rms.repository.FoodRepository;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public FoodItem create(FoodItem food_item){
        return foodRepository.save(food_item);
    }

    public List<FoodItem> findAll(){
        return foodRepository.findAll();
    }

    public FoodItem findById(long ProductsID){
        return foodRepository.findById(ProductsID).get();
    }

    public void delete(Long ProductsID){
        FoodItem food_item = foodRepository.getOne(ProductsID);
        foodRepository.delete(food_item);
    }

    public void deleteAll(){
        foodRepository.deleteAll();
    }

    public void update(FoodItem food_item){
        foodRepository.save(food_item);
    }
}
