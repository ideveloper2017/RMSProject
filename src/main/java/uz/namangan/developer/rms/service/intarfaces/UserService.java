package uz.namangan.developer.rms.service.intarfaces;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import uz.namangan.developer.rms.dto.SignUpDto;
import uz.namangan.developer.rms.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService<T> extends UserDetailsService {

    User findByEmail(String email);
    User save(SignUpDto register);
    User findByUsernameOrEmail(String value);
    List<T> getAllUserList();
    Page<T> findAll(Pageable pageable, String searchText);
    Page<T> findAll(Pageable pageable);
    Optional<T> findById(Long id);

    User findByPinCode(String pincode);
//    User save(UserRegistrationDto registration);
}
