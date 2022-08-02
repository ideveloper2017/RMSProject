package uz.namangan.developer.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.namangan.developer.rms.model.table.TableFloor;


import java.util.Optional;

@Repository
public interface TableFloorRepository extends JpaRepository<TableFloor, Integer> {
    Boolean existsByFloorname(String username);
    Boolean existsByFloorname(TableFloor obj);
    Optional<TableFloor> findByIdAndFloorname(int id, String obj);
}
