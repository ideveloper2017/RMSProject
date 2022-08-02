package uz.namangan.developer.rms.service;


import antlr.debug.TraceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.model.table.TableFloor;
import uz.namangan.developer.rms.repository.TableFloorRepository;
import uz.namangan.developer.rms.service.intarfaces.TableFloorService;


import java.util.List;
import java.util.Optional;

@Service
public class TableFloorServiceImpl implements TableFloorService {

    private TableFloorRepository floorRepository;

    public TableFloorServiceImpl(TableFloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    @Override
    public TableFloor save(TableFloor obj) {
        return  floorRepository.save(obj);
    }

    @Override
    public List<TableFloor> findAll() {
        return floorRepository.findAll();
    }

    @Override
    public void delete(int id) {
        floorRepository.deleteById(id);
    }

    @Override
    public TableFloor update(TableFloor obj) {
        return floorRepository.saveAndFlush(obj);
    }

    @Override
    public Optional<TableFloor> find(int id) {
        return floorRepository.findById(id);
    }

    @Override
    public boolean find(String obj) {
        return floorRepository.existsByFloorname(obj);
    }

    @Override
    public Optional<TableFloor> find(TableFloor obj) {
        return floorRepository.findByIdAndFloorname(obj.getId(),obj.getFloorname());
    }
}
