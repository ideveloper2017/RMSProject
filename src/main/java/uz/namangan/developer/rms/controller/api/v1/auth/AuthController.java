package uz.namangan.developer.rms.controller.api.v1.auth;//package uz.developer.rms.controller.api.v1.auth;
//
//
//
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//import uz.developer.rms.dto.LoginDto;
//import uz.developer.rms.dto.SignUpDto;
//import uz.developer.rms.model.Role.Role;
//import uz.developer.rms.model.users.User;
//import uz.developer.rms.repository.RoleRepository;
//import uz.developer.rms.repository.UserRepository;
//import uz.developer.rms.security.JwtTokenProvider;
//import uz.developer.rms.service.intarfaces.UserService;
//
//import java.util.Iterator;
//
//@RestController
//@RequestMapping("/api/v1/auth")
////@CrossOrigin(origins="http://localhost:3000")
//public class AuthController {
//
//    private static Logger log = LoggerFactory.getLogger(AuthController.class);
//
////    @Autowired
////    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UserService userService;
//
//
//    @Autowired
//    private JwtTokenProvider tokenProvider;
//
//    @PostMapping(value = "/signin",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?>authenticateUser(@RequestBody LoginDto loginDto) throws JSONException {
//
////        log.info("UserResourceImpl : authenticate");
////
////        JSONObject jsonObject=new JSONObject();
////
////        try{
////            Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(),loginDto.getPassword()));
////            SecurityContextHolder.getContext().setAuthentication(authentication);
////            if (authentication.isAuthenticated()) {
////                String email = loginDto.getUsernameOrEmail();
////                jsonObject.put("name",authentication.getName());
////                jsonObject.put("authorities",authentication.getAuthorities());
////                Iterator<Role> iterRole=userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(),loginDto.getUsernameOrEmail()).get().getRoles().iterator();
////                Role role;
////                if (iterRole.hasNext()){
////                    role=(Role) iterRole.next();
////                    jsonObject.put("token", tokenProvider.createToken(email, role));
////                    jsonObject.put("role", role.getName());
////                } else {
////                    jsonObject.put("token", "");
////                }
////            }
////            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
////        } catch (JSONException e) {
////            try {
////                jsonObject.put("exception",e.getMessage());
////            } catch (JSONException ex) {
////                ex.printStackTrace();
////            }
////            return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.UNAUTHORIZED);
////        }
//        return null;
//    }
//
//
//
//
//}
