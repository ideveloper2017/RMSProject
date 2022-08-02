package uz.namangan.developer.rms.service;

import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.model.food.AddonsList;
import uz.namangan.developer.rms.repository.AddonsListRepository;

import java.util.List;

@Service
public class AddonsListService {

    private final AddonsListRepository addonsListRepository;

    public AddonsListService(AddonsListRepository addonsListRepository) {
        this.addonsListRepository = addonsListRepository;
    }
    public AddonsList create(AddonsList addons_list){
        return addonsListRepository.save(addons_list);
    }

    public List<AddonsList> findAll(){
        return addonsListRepository.findAll();
    }

    public AddonsList findById(long id){
        return addonsListRepository.findById(id).get();
    }

    public void delete(Long id){
        AddonsList addonsList = addonsListRepository.getOne(id);
        addonsListRepository.delete(addonsList);
    }

    public void deleteAll(){
        addonsListRepository.deleteAll();
    }

    public void update(AddonsList addons_list){
        addonsListRepository.save(addons_list);
    }

}
