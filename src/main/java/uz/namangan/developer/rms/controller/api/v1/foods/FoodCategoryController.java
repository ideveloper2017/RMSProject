package uz.namangan.developer.rms.controller.api.v1.foods;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developer.rms.model.food.FoodCategory;
import uz.developer.rms.service.FoodCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class FoodCategoryController {

    private final FoodCategoryService foodCategoryService;

    public FoodCategoryController(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }

    @PostMapping("/foodcategory")
    public ResponseEntity create(@RequestBody FoodCategory food_category){
        FoodCategory food_category1 = foodCategoryService.create(food_category);
        return ResponseEntity.ok(food_category1);
    }

    @GetMapping("/getallfoodcategory")
    public ResponseEntity getall(){
        List<FoodCategory> food_categories = foodCategoryService.findAll();
        return ResponseEntity.ok(food_categories);
    }

    @GetMapping("/getfoodcategory/{id}")
    public ResponseEntity getByID(@PathVariable long id){
        FoodCategory food_category = foodCategoryService.findById(id);
        return ResponseEntity.ok(food_category);
    }

    @DeleteMapping("/deletefoodcategory/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        foodCategoryService.delete(id);
        return ResponseEntity.ok("qator o'chirildi...");
    }

    @DeleteMapping("/deletefoodcategory")
    public ResponseEntity deleteAll(){
        foodCategoryService.deleteAll();
        return ResponseEntity.ok("hamma qator o'chirildi...");
    }


    @PutMapping("/updatefoodcategory")
    public ResponseEntity update(@RequestBody FoodCategory food_category){
        foodCategoryService.update(food_category);
        return ResponseEntity.ok("updated");
    }
}
