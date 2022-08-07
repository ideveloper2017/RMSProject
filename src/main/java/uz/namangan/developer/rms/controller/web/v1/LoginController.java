package uz.namangan.developer.rms.controller.web.v1;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.namangan.developer.rms.controller.api.v1.auth.AuthController;
import uz.namangan.developer.rms.dto.LoginDto;
import uz.namangan.developer.rms.model.user.Role;
import uz.namangan.developer.rms.model.user.User;
import uz.namangan.developer.rms.repository.RoleRepository;
import uz.namangan.developer.rms.repository.UserRepository;
import uz.namangan.developer.rms.security.CurrentUser;
import uz.namangan.developer.rms.security.UserPrincipal;
import uz.namangan.developer.rms.service.intarfaces.UserService;

import javax.servlet.http.HttpSession;
import java.util.Iterator;

@Controller
public class LoginController {


    private static Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView root(@CurrentUser UserPrincipal currentuser, Model model, HttpSession session) {
        System.out.println(currentuser.toString());
        ModelAndView modelAndView=new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
            User user = userService.findByUsernameOrEmail(auth.getName());
//        modelAndView.addObject("user",user);
//        model.addAttribute("userName", "Welcome " + user.getFirstname() + " " + user.getLastname() + " (" + user.getEmail() + ")");
//        model.addAttribute("adminMessage", "Content Available Only for Users with Admin Role");
            modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
            modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");

            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;

    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/proccesslogin")
    public ModelAndView loginProccess(@ModelAttribute("login")   LoginDto loginDto){

        ModelAndView modelAndView=new ModelAndView();

            Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(),loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            if (authentication.isAuthenticated()) {
                String email = loginDto.getUsernameOrEmail();
                User user=userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(),loginDto.getUsernameOrEmail());
                Iterator<Role> iterRole=user.getRoles().iterator();

                modelAndView.setViewName("index");
            } else {
              modelAndView.setViewName("login");
            }

        return modelAndView;
    }


}
