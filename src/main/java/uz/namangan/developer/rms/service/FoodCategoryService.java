package uz.namangan.developer.rms.service;

import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.model.food.FoodCategory;
import uz.namangan.developer.rms.repository.FoodCategoryRepository;

import java.util.List;

@Service
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public FoodCategoryService(FoodCategoryRepository foodCategoryRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
    }
    public FoodCategory create(FoodCategory food_category){
        return foodCategoryRepository.save(food_category);
    }

    public List<FoodCategory> findAll(){
        return foodCategoryRepository.findAll();
    }

    public FoodCategory findById(long id){
        return foodCategoryRepository.findById(id).get();
    }

    public void delete(Long id){
        FoodCategory food_category = foodCategoryRepository.getOne(id);
        foodCategoryRepository.delete(food_category);
    }

    public void deleteAll(){
        foodCategoryRepository.deleteAll();
    }

    public void update(FoodCategory food_category){
        foodCategoryRepository.save(food_category);
    }

}
