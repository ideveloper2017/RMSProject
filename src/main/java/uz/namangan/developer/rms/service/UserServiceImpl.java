package uz.namangan.developer.rms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.namangan.developer.rms.model.user.Role;
import uz.namangan.developer.rms.model.user.User;
import uz.namangan.developer.rms.repository.UserRepository;
import uz.namangan.developer.rms.security.UserPrincipal;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

//    public User save(UserRegistrationDto registration){
//        User user = new User();
//        user.setFirstName(registration.getFirstName());
//        user.setLastName(registration.getLastName());
//        user.setEmail(registration.getEmail());
//        user.setPassword(new BCryptPasswordEncoder().encode(registration.getPassword()));
//        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
//        return userRepository.save(user);
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return UserPrincipal.create(user);
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                user.getPassword(),
//                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }


}
