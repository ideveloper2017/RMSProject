package uz.namangan.developer.rms.controller.api.v1.table;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developer.rms.dto.TableFloorDto;
import uz.developer.rms.model.products.Product;
import uz.developer.rms.model.table.TableFloor;
import uz.developer.rms.payload.ApiResponse;
import uz.developer.rms.service.TableFloorServiceImpl;
import uz.developer.rms.service.intarfaces.TableFloorService;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tablefloor")
public class TableFloorController {

    @Autowired
    TableFloorService floorService;

    private String message;
    private Boolean success;
    private HttpStatus http;

    @PostMapping("/addnewtablefloor")
    private ResponseEntity<TableFloor> addNewTableFloor(@RequestBody TableFloorDto tableFloorDto){
            if (floorService.find(tableFloorDto.getFloorname())){
                floorService.update(new TableFloor(tableFloorDto.getFloorname()));
                message="Malumot o'zgartirildi";
                success=true;
                http=HttpStatus.OK;

               } else {
                floorService.save(new TableFloor(tableFloorDto.floorname));
                http=HttpStatus.OK;
                message="Yangi ma`lumot qo'shildi";
                success=true;
               }
        return new ResponseEntity(new ApiResponse<TableFloor>(success,message), http);
    }

    @PostMapping("/updatetablefloor")
    private ResponseEntity<TableFloor> updatetablefloor(@RequestBody TableFloorDto tableFloorDto){

        Optional<TableFloor>tableFloor=floorService.find(tableFloorDto.getId());

        if (tableFloor.isPresent()){
            floorService.update(new TableFloor(tableFloorDto.getId(),tableFloorDto.getFloorname()));
            message="Malumot o'zgartirildi";
            success=true;
            http=HttpStatus.OK;
        } else {
            http=HttpStatus.OK;
            message="Ma`lumot topilmadi";
            success=false;
        }
        return new ResponseEntity(new ApiResponse<TableFloor>(success,message), http);
    }

    @GetMapping("/getalltablefloor")
    private ResponseEntity<TableFloor> getAllTableFloor(){
        List<TableFloor> allListFloor=floorService.findAll();
        if (allListFloor.size()>0){
            http=HttpStatus.OK;
            message="All fetch data";
            success=true;
        } else {
            http=HttpStatus.NOT_FOUND;
            message="All fetch data";
            success=false;
        }
        return new ResponseEntity(new ApiResponse<TableFloor>(success,message,allListFloor), http);
    }

    @GetMapping("/gettablefloor")
    private ResponseEntity<TableFloor> getTableFloorFindById(@RequestParam int id){
        Optional<TableFloor>tableFloor= floorService.find(id);
        List<TableFloor>tableFloorsList=new ArrayList<>();
        tableFloorsList.add(tableFloor.get());
        if (tableFloorsList.size()>0) {
            http = HttpStatus.OK;
            message = "Get fetch data";
            success = true;
        } else {
            http = HttpStatus.NOT_FOUND;
            message = "Not found data";
            success = false;
        }

        return new ResponseEntity(new ApiResponse<TableFloor>(success,message, tableFloorsList), http);
    }

    @GetMapping("/deletetablefloor")
    private ResponseEntity<TableFloor> deleteFloorTable(@RequestParam int id){
        Optional<TableFloor>tableFloor= floorService.find(id);
        if (tableFloor.isPresent()) {
            http = HttpStatus.OK;
            message = "Tanlangan ma`lumot uchirildi";
            success = true;
            floorService.delete(id);
        } else {
            http = HttpStatus.OK;
            message = "Ma`lumot topilmadi!!!";
            success = false;
        }

        return new ResponseEntity(new ApiResponse<TableFloor>(success,message), http);
    }
}
