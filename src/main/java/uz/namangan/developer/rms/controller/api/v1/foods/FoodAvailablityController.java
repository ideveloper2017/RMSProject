package uz.namangan.developer.rms.controller.api.v1.foods;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.namangan.developer.rms.model.food.FoodAvailablity;
import uz.namangan.developer.rms.service.FoodAvailablityService;


import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class FoodAvailablityController {
    private final FoodAvailablityService foodAvailablityService;

    public FoodAvailablityController(FoodAvailablityService foodAvailablityService) {
        this.foodAvailablityService = foodAvailablityService;
    }
    @PostMapping("/foodavailablity")
    public ResponseEntity create(@RequestBody FoodAvailablity food_availablity){
        FoodAvailablity food_availablity1 = foodAvailablityService.create(food_availablity);
        return ResponseEntity.ok(food_availablity1);
    }

    @GetMapping("/getallfoodavailablity")
    public ResponseEntity getall(){
        List<FoodAvailablity> food_availablities = foodAvailablityService.findAll();
        return ResponseEntity.ok(food_availablities);
    }

    @GetMapping("/getfoodavailablity/{id}")
    public ResponseEntity getByID(@PathVariable long id){
        FoodAvailablity food_availablity = foodAvailablityService.findById(id);
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
    public ResponseEntity update(@RequestBody FoodAvailablity food_availablity){
        foodAvailablityService.update(food_availablity);
        return ResponseEntity.ok("updated");
    }
}
