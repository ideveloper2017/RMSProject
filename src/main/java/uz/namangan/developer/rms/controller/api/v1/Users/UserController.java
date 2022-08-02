package uz.namangan.developer.rms.controller.api.v1.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developer.rms.dto.SignUpDto;
import uz.developer.rms.model.users.User;
import uz.developer.rms.repository.UserRepository;
import uz.developer.rms.service.intarfaces.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/alluser/search/{searchText}")
    public ResponseEntity<Page<User>>findAll(Pageable pageable,@PathVariable  String searchText){
        return new ResponseEntity<>(userService.findAll(pageable,searchText), HttpStatus.OK);
    }


    @GetMapping("/alluser")
    public ResponseEntity<Page<User>>findAll(int pageNumber,int pageSize,String sortBy,String sortDir){
        return new ResponseEntity<>(userService.findAll(
                PageRequest.of(pageNumber,pageSize,sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending():Sort.by(sortBy).descending())
        ),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return  new ResponseEntity<User>((User) userService.findById(id).get(),HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String>registerUser(@RequestBody SignUpDto signUpDto){

        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        userService.save(signUpDto);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<User>registerUpdate(@RequestBody SignUpDto signUpDto){
        return new ResponseEntity<>(userService.save(signUpDto), HttpStatus.OK);
    }


    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable Long id){
        //userService.deleteUser(id);
        return new ResponseEntity<String>("User Deleted!!!",HttpStatus.OK);
    }
}
