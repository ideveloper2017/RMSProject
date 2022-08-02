package uz.namangan.developer.rms.controller.api.v1.foods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uz.developer.rms.model.food.FoodItem;
import uz.developer.rms.model.menu.MenuType;
import uz.developer.rms.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class FoodController {

    @Autowired
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/fooditem")
    public ResponseEntity create(@RequestBody FoodItem food_item){
        FoodItem food_item1 = foodService.create(food_item);
        return ResponseEntity.ok(food_item1);
    }

    @GetMapping("/getallfooditem")
    public ResponseEntity getall(){
        List<FoodItem> food_item = foodService.findAll();
        return ResponseEntity.ok(food_item);
    }

    @GetMapping("/getfooditem/{ProductsID}")
    public ResponseEntity getByID(@PathVariable long ProductsID){
        FoodItem food_item = foodService.findById(ProductsID);
        return ResponseEntity.ok(food_item);
    }

    @DeleteMapping("/deletefooditem/{ProductsID}")
    public ResponseEntity delete(@PathVariable Long ProductsID){
        foodService.delete(ProductsID);
        return ResponseEntity.ok("qator o'chirildi...");
    }

    @DeleteMapping("/deletefooditem")
    public ResponseEntity deleteAll(){
        foodService.deleteAll();
        return ResponseEntity.ok("hamma qator o'chirildi...");
    }


    @PutMapping("/updatefooditem")
    public ResponseEntity update(@RequestBody FoodItem food_item){
        foodService.update(food_item);
        return ResponseEntity.ok("updated");
    }
}
