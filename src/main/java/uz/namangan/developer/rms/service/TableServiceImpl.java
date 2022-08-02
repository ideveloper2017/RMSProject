package uz.namangan.developer.rms.service;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.model.table.RestTable;
import uz.namangan.developer.rms.repository.TablesRepository;
import uz.namangan.developer.rms.service.intarfaces.TablesService;


import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements TablesService {

    TablesRepository tablesRepository;



    public TableServiceImpl(TablesRepository tablesRepository) {
        this.tablesRepository = tablesRepository;
    }

    @Override
    public RestTable save(RestTable obj) {
        return tablesRepository.save(obj);
    }

    @Override

    public List<RestTable> findAll() {
        return (List<RestTable>) tablesRepository.getTablesList();
    }

    @Override
    public void delete(int id) {
        tablesRepository.deleteById(id);
    }

    @Override
    public RestTable update(RestTable obj) {
        return tablesRepository.save(obj);
    }

    @Override
    public Optional<RestTable> find(int id) {
        return tablesRepository.findById(id);
    }

    @Override
    public boolean find(String obj) {
        return tablesRepository.existsByTablename(obj);
    }

    @Override
    public Optional<RestTable> find(RestTable obj) {
        return  tablesRepository.existsByIdAndTablename(obj.getId(),obj.getTablename());
    }
}
