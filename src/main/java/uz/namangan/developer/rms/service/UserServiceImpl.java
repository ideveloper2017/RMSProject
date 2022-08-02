package uz.namangan.developer.rms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.namangan.developer.rms.dto.SignUpDto;
import uz.namangan.developer.rms.model.user.Role;
import uz.namangan.developer.rms.model.user.User;
import uz.namangan.developer.rms.repository.UserRepository;
import uz.namangan.developer.rms.security.UserPrincipal;
import uz.namangan.developer.rms.service.intarfaces.UserService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService<User> {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(SignUpDto register) {
        return null;
    }

    @Override
    public User findByUsernameOrEmail(String value) {
        return null;
    }

    @Override
    public List<User> getAllUserList() {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable, String searchText) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
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
