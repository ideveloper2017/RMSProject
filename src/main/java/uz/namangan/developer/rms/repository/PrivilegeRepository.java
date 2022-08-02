package uz.namangan.developer.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.namangan.developer.rms.model.permissions.Privilege;


import java.util.Collection;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
    Privilege findByName(String name);
}
