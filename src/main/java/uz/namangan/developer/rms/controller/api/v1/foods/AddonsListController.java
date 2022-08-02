package uz.namangan.developer.rms.controller.api.v1.foods;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developer.rms.model.food.AddonsList;
import uz.developer.rms.service.AddonsListService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class AddonsListController {
    private final AddonsListService addonsListService;

    public AddonsListController(AddonsListService addonsListService) {
        this.addonsListService = addonsListService;
    }

    @PostMapping("/addonslist")
    public ResponseEntity create(@RequestBody AddonsList addons_list){
        AddonsList addonsList1 = addonsListService.create(addons_list);
        return ResponseEntity.ok(addonsList1);
    }

    @GetMapping("/getalladdonslist")
    public ResponseEntity getall(){
        List<AddonsList> addons_lists = addonsListService.findAll();
        return ResponseEntity.ok(addons_lists);
    }

    @GetMapping("/getaddonslist/{id}")
    public ResponseEntity getByID(@PathVariable long id){
        AddonsList addonsList = addonsListService.findById(id);
        return ResponseEntity.ok(addonsList);
    }

    @DeleteMapping("/deleteaddonslist/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        addonsListService.delete(id);
        return ResponseEntity.ok("qator o'chirildi...");
    }

    @DeleteMapping("/deleteaddonslist")
    public ResponseEntity deleteAll(){
        addonsListService.deleteAll();
        return ResponseEntity.ok("hamma qator o'chirildi...");
    }


    @PutMapping("/updateaddonslist")
    public ResponseEntity update(@RequestBody AddonsList addons_list){
        addonsListService.update(addons_list);
        return ResponseEntity.ok("updated");
    }
}
