package uz.namangan.developer.rms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import uz.namangan.developer.rms.model.permissions.Privilege;
import uz.namangan.developer.rms.model.user.Role;
import uz.namangan.developer.rms.model.user.User;
import uz.namangan.developer.rms.repository.PrivilegeRepository;
import uz.namangan.developer.rms.repository.RoleRepository;
import uz.namangan.developer.rms.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.*;

@SpringBootApplication
public class RmsProjectApplication extends SpringBootServletInitializer implements CommandLineRunner {


	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PrivilegeRepository privilegeRepository;

	public static void main(String[] args) {
		SpringApplication.run(RmsProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Instant now = Instant.now();




		if (roleRepository.findAll().isEmpty()) {
			Role adminRole = new Role();
			adminRole.setRole("ROLE_ADMIN");
			adminRole.setName("Администратор");
			adminRole.setCreatedAt(now);
			adminRole.setUpdatedAt(now);
			roleRepository.save(adminRole);

			Role userRole = new Role();
			adminRole.setRole("ROLE_USER");
			userRole.setName("Пользователь");
			userRole.setCreatedAt(now);
			userRole.setUpdatedAt(now);
			roleRepository.save(userRole);
		}


		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		Privilege readPrivilege	 = createPrivilegeIfNotFound("READ_PRIVILEGE");

		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);

		createRoleIfNotFound("ROLE_ADMIN","Администратор", adminPrivileges);
		createRoleIfNotFound("ROLE_USER","Пользователь", Arrays.asList(readPrivilege));



		if (userRepository.count()==0) {
			User user = new User();
			user.setFirstName("Parpiyev");
			user.setLastName("Baxrom");
			user.setEmail("bahrom1982@gmail.com");
			user.setUsername("admin");
			user.setPassword(new BCryptPasswordEncoder().encode("19820208"));
			user.setIsActive(1);
			user.setIsLogin(0);
			Role roles = (Role) roleRepository.findByName("Администратор");
			user.setRoles(Arrays.asList(roles));
			user.setCreatedAt(now);
			user.setUpdatedAt(now);
			userRepository.save(user);

		}
	}


	@Transactional
	Role createRoleIfNotFound(String name,String title, Collection<Privilege> privileges) {
		Instant now = Instant.now();
		Role role = (Role) roleRepository.findByRole(name);
		if (role == null) {
			role = new Role();
			role.setName(title);
			role.setRole(name);
			role.setCreatedAt(now);
			role.setUpdatedAt(now);
			role.setPrivileges(privileges);
			roleRepository.save(role);
		}
		return role;
	}

	@Transactional
	Privilege createPrivilegeIfNotFound(String name) {

		Privilege privilege = privilegeRepository.findByName(name);
		if (privilege == null) {
			privilege = new Privilege(name);
			privilegeRepository.save(privilege);
		}
		return privilege;
	}
}
