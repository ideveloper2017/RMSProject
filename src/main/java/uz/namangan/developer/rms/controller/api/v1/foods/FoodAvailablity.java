package uz.namangan.developer.rms.controller.api.v1.foods;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developer.rms.service.FoodAvailablityService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class FoodAvailablity {
    private final FoodAvailablityService foodAvailablityService;

    public FoodAvailablity(FoodAvailablityService foodAvailablityService) {
        this.foodAvailablityService = foodAvailablityService;
    }
    @PostMapping("/foodavailablity")
    public ResponseEntity create(@RequestBody uz.developer.rms.model.food.FoodAvailablity food_availablity){
        uz.developer.rms.model.food.FoodAvailablity food_availablity1 = foodAvailablityService.create(food_availablity);
        return ResponseEntity.ok(food_availablity1);
    }

    @GetMapping("/getallfoodavailablity")
    public ResponseEntity getall(){
        List<uz.developer.rms.model.food.FoodAvailablity> food_availablities = foodAvailablityService.findAll();
        return ResponseEntity.ok(food_availablities);
    }

    @GetMapping("/getfoodavailablity/{id}")
    public ResponseEntity getByID(@PathVariable long id){
        uz.developer.rms.model.food.FoodAvailablity food_availablity = foodAvailablityService.findById(id);
        return ResponseEntity.ok(food_availablity);
    }

    @DeleteMapping("/deletefoodavailablity/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        foodAvailablityService.delete(id);
        return ResponseEntity.ok("qator o'chirildi...");
    }

    @DeleteMapping("/deletefoodavailablity")
    public ResponseEntity deleteAll(){
        foodAvailablityService.deleteAll();
        return ResponseEntity.ok("hamma qator o'chirildi...");
    }


    @PutMapping("/updatefoodavailablity")
    public ResponseEntity update(@RequestBody uz.developer.rms.model.food.FoodAvailablity food_availablity){
        foodAvailablityService.update(food_availablity);
        return ResponseEntity.ok("updated");
    }
}
