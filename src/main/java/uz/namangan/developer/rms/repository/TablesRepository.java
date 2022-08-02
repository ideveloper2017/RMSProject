package uz.namangan.developer.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.namangan.developer.rms.model.table.RestTable;


import java.util.List;
import java.util.Optional;

@Repository("tablesRepository")
public interface TablesRepository extends JpaRepository<RestTable,Integer> {

   Boolean existsByTablename(String tablename);

   Optional<RestTable> existsByIdAndTablename(int id, String name);

   @Modifying(clearAutomatically = true)
   @Transactional
   @Query("SELECT r FROM RestTable r WHERE r.status=1")
   List<RestTable> getTablesList();
}
