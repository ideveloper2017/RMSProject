package uz.namangan.developer.rms.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import uz.namangan.developer.rms.model.user.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

//    User save(UserRegistrationDto registration);
}
