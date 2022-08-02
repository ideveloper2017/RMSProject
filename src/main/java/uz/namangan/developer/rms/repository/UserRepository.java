package uz.namangan.developer.rms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.namangan.developer.rms.model.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);


	//    @Query("select u from User u where u.isActive=1")
	User findByUsernameOrEmail(String username, String email);
	User findByUsername(String username);

	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	@Query("FROM User u where u.firstName LIKE %:searchtext% or u.lastName LIKE %:searchtext% ")
	Page<User> findAllUsers(Pageable pageable, @Param("searchtext") String searchtext);
}
