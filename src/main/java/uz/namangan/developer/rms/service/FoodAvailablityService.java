package uz.namangan.developer.rms.service;

import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.model.food.FoodAvailablity;
import uz.namangan.developer.rms.repository.FoodAvailablityRepository;


import java.util.List;

@Service
public class FoodAvailablityService {
    private final FoodAvailablityRepository foodAvailablityRepository;

    public FoodAvailablityService(FoodAvailablityRepository foodAvailablityRepository) {
        this.foodAvailablityRepository = foodAvailablityRepository;
    }
    public FoodAvailablity create(FoodAvailablity food_availablity){
        return foodAvailablityRepository.save(food_availablity);
    }

    public List<FoodAvailablity> findAll(){
        return foodAvailablityRepository.findAll();
    }

    public FoodAvailablity findById(long id){
        return foodAvailablityRepository.findById(id).get();
    }

    public void delete(Long id){
        FoodAvailablity food_availablity = foodAvailablityRepository.getOne(id);
        foodAvailablityRepository.delete(food_availablity);
    }

    public void deleteAll(){
        foodAvailablityRepository.deleteAll();
    }

    public void update(FoodAvailablity food_availablity){
        foodAvailablityRepository.save(food_availablity);
    }
}
