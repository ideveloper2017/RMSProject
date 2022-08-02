package uz.namangan.developer.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.namangan.developer.rms.model.menu.MenuType;


@Repository
public interface MenuTypeRepository extends JpaRepository<MenuType, Long> {

}
