package uz.namangan.developer.rms.controller.api.v1.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developer.rms.model.menu.MenuType;
import uz.developer.rms.service.MenuTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuTypeController {

    @Autowired
    private final MenuTypeService menuTypeService;

    public MenuTypeController(MenuTypeService menuTypeService) {
        this.menuTypeService = menuTypeService;
    }

    @PostMapping("/menutype")
    public ResponseEntity create(@RequestBody MenuType menuType){
        MenuType menuType1 = menuTypeService.create(menuType);
        return ResponseEntity.ok(menuType1);
    }

    @GetMapping("/getallmenutype")
    public ResponseEntity getall(){
        List<MenuType> menuTypes = menuTypeService.findAll();
        return ResponseEntity.ok(menuTypes);
    }

    @GetMapping("/getmenutype/{menutypeid}")
    public ResponseEntity getByID(@PathVariable long menutypeid){
        MenuType menuType = menuTypeService.findById(menutypeid);
        return ResponseEntity.ok(menuType);
    }

    @DeleteMapping("/deletemenutype/{menutypeid}")
    public ResponseEntity delete(@PathVariable Long menutypeid){
        menuTypeService.delete(menutypeid);
        return ResponseEntity.ok("qator o'chirildi...");
    }

    @DeleteMapping("/deletemenutype")
    public ResponseEntity deleteAll(){
        menuTypeService.deleteAll();
        return ResponseEntity.ok("hamma qator o'chirildi...");
    }


    @PutMapping("/updatemenutype")
    public ResponseEntity update(@RequestBody MenuType menuType){
        menuTypeService.update(menuType);
        return ResponseEntity.ok("updated");
    }
}
