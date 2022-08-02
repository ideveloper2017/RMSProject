package uz.namangan.developer.rms.controller.api.v1.products;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.namangan.developer.rms.model.products.Product_category;
import uz.namangan.developer.rms.service.ProductCategoryService;


import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("/productcategory")
    public ResponseEntity create(@RequestBody Product_category product_category){
        Product_category product_category1 = productCategoryService.create(product_category);
        return ResponseEntity.ok(product_category1);
    }

    @GetMapping("/getallproductcategory")
    public ResponseEntity getall(){
        List<Product_category> product_category = productCategoryService.findAll();
        return ResponseEntity.ok(product_category);
    }

    @GetMapping("/getproductcategory/{id}")
    public ResponseEntity getByID(@PathVariable long id){
        Product_category product_category = productCategoryService.findById(id);
        return ResponseEntity.ok(product_category);
    }

    @DeleteMapping("/deleteproductcategory/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productCategoryService.delete(id);
        return ResponseEntity.ok("qator o'chirildi...");
    }

    @DeleteMapping("/deleteproductcategory")
    public ResponseEntity deleteAll(){
        productCategoryService.deleteAll();
        return ResponseEntity.ok("hamma qator o'chirildi...");
    }


    @PutMapping("/updateproductcategory")
    public ResponseEntity update(@RequestBody Product_category product_category){
        productCategoryService.update(product_category);
        return ResponseEntity.ok("updated");
    }
}
