package uz.namangan.developer.rms.service;

import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.model.menu.MenuType;
import uz.namangan.developer.rms.repository.MenuTypeRepository;

import java.util.List;

@Service
public class MenuTypeService {

    private final MenuTypeRepository menuTypeRepository;

    public MenuTypeService(MenuTypeRepository menuTypeRepository) {
        this.menuTypeRepository = menuTypeRepository;
    }

    public MenuType create(MenuType menuType){
        return menuTypeRepository.save(menuType);
    }

    public List<MenuType> findAll(){
        return menuTypeRepository.findAll();
    }

    public MenuType findById(long menutypeid){
        return menuTypeRepository.findById(menutypeid).get();
    }

    public void delete(Long menutypeid){
        MenuType menuType = menuTypeRepository.getOne(menutypeid);
        menuTypeRepository.delete(menuType);
    }

    public void deleteAll(){
        menuTypeRepository.deleteAll();
    }

    public void update(MenuType menuType){
        menuTypeRepository.save(menuType);
    }
}
