package uz.namangan.developer.rms.controller.api.v1.table;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.namangan.developer.rms.dto.RestTableDto;
import uz.namangan.developer.rms.model.table.RestTable;
import uz.namangan.developer.rms.model.table.TableFloor;
import uz.namangan.developer.rms.payload.ApiResponse;
import uz.namangan.developer.rms.service.intarfaces.TablesService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/tables")
public class TableController {


    @Autowired
    TablesService tablesService;

    private String message;
    private Boolean success;
    private HttpStatus http;


    @PostMapping("/addtable")
    public ResponseEntity<?> addTable(@RequestBody RestTableDto restTableDto) {
        if (tablesService.find(restTableDto.getTablename())) {
            tablesService.update(new RestTable(restTableDto.getId(), restTableDto.getTablename(), restTableDto.getPersoncapicity(), restTableDto.getTableicon(), new TableFloor(restTableDto.getFloor()), restTableDto.getStatus()));
            message = "Muvaffaqiyatli uzgartirildi!!!";
            success = true;
        } else {

            tablesService.save(new RestTable(restTableDto.getTablename(), restTableDto.getPersoncapicity(), restTableDto.getTableicon(), new TableFloor(restTableDto.getFloor()), restTableDto.getStatus()));
            message = "Muvaffaqiyatli qo'shildi!!!";
            success = true;
        }
        return new ResponseEntity(new ApiResponse<RestTable>(success, message), HttpStatus.OK);
    }

    @PostMapping("/addtables")
    public ResponseEntity<?> addTables(@RequestBody List<RestTableDto> restTableDto) {

        for (int i = 0; i < restTableDto.size(); i++) {
            RestTableDto restTable = restTableDto.get(i);
            if (tablesService.find(restTable.getTablename())) {
                tablesService.update(new RestTable(restTable.getId(), restTable.getTablename(), restTable.getPersoncapicity(), restTable.getTableicon(), new TableFloor(restTable.getFloor()), restTable.getStatus()));
                message = "Muvaffaqiyatli uzgartirildi!!!";
                success = true;
            } else {

                tablesService.save(new RestTable(restTable.getTablename(), restTable.getPersoncapicity(), restTable.getTableicon(), new TableFloor(restTable.getFloor()), restTable.getStatus()));
                message = "Muvaffaqiyatli qo'shildi!!!";
                success = true;
            }

        }

        return new ResponseEntity(new ApiResponse<RestTable>(success, message), HttpStatus.OK);
    }

    @PostMapping("/updatetable")
    public ResponseEntity<?> updateTable(@RequestBody RestTableDto restTableDto) {
        TableFloor tableFloor = new TableFloor(restTableDto.getFloor());
        RestTable restTable = new RestTable(restTableDto.getId(), restTableDto.getTablename(), restTableDto.getPersoncapicity(), restTableDto.getTableicon(), tableFloor, restTableDto.getStatus());

        if (tablesService.find(restTable).isPresent()) {
            tablesService.update(restTable);
            message = "Muvaffaqiyatli uzgartirildi!!!";
            success = true;
        }
        return new ResponseEntity(new ApiResponse<RestTable>(success, message), HttpStatus.OK);
    }

    @PostMapping("/updatetables")
    public ResponseEntity<?> updateTables(@RequestBody List<RestTableDto> restTableDto) {
        for(int i=0;i<restTableDto.size();i++) {
            RestTableDto restTableDTO=restTableDto.get(i);
            TableFloor tableFloor = new TableFloor(restTableDTO.getFloor());
            RestTable restTable = new RestTable(restTableDTO.getId(), restTableDTO.getTablename(), restTableDTO.getPersoncapicity(), restTableDTO.getTableicon(), tableFloor, restTableDTO.getStatus());

            if (tablesService.find(restTable).isPresent()) {
                tablesService.update(restTable);
                message = "Muvaffaqiyatli uzgartirildi!!!";
                success = true;
            }
        }
        return new ResponseEntity(new ApiResponse<RestTable>(success, message), HttpStatus.OK);
    }

    @GetMapping("/gettables")
    public ResponseEntity<?> gettables(@RequestParam int id) {

        Optional<RestTable> restTable = tablesService.find(id);
        List<RestTable> restTableList = new ArrayList<>();
        restTableList.add(restTable.get());
        message = "Fetch all data";
        success = true;
        return new ResponseEntity(new ApiResponse<RestTable>(success, message, restTableList), HttpStatus.OK);
    }


    @GetMapping("/getalltables")
    public ResponseEntity<?> getAllTables() {
        List<RestTable> resultTableList = new ArrayList<>();
        List<RestTable> restTableList = tablesService.findAll();

        if (!restTableList.isEmpty()) {
            message = "Fetch all data";
            success = true;
            resultTableList.clear();
            resultTableList.addAll(restTableList);
        } else {
            message = "Fetch all data";
            success = true;
        }

        return new ResponseEntity(new ApiResponse<RestTable>(success, message, resultTableList), HttpStatus.OK);
    }

    @GetMapping("/deletetable")
    public ResponseEntity<?> deleteTable(@RequestParam int id) {

        Optional<RestTable> restTableList = tablesService.find(id);

        if (restTableList.isPresent()) {
            tablesService.delete(id);
            message = "Учирилди";
            success = true;
        } else {
            message = "Учирилмади";
            success = true;
        }

        return new ResponseEntity(new ApiResponse<RestTable>(success, message), HttpStatus.OK);
    }


}
