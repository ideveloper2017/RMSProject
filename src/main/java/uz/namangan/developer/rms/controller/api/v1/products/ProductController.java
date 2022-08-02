package uz.namangan.developer.rms.controller.api.v1.products;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.namangan.developer.rms.model.products.Product;
import uz.namangan.developer.rms.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity create(@RequestBody Product product){
        Product product1 = productService.create(product);
        return ResponseEntity.ok(product1);
    }

    @GetMapping("/getallproduct")
    public ResponseEntity getall(){
        List<Product> product = productService.findAll();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/getproduct/{id}")
    public ResponseEntity getByID(@PathVariable long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok("qator o'chirildi...");
    }

    @DeleteMapping("/deleteproduct")
    public ResponseEntity deleteAll(){
        productService.deleteAll();
        return ResponseEntity.ok("hamma qator o'chirildi...");
    }


    @PutMapping("/updateproduct")
    public ResponseEntity update(@RequestBody Product product){
        productService.update(product);
        return ResponseEntity.ok("updated");
    }
}
