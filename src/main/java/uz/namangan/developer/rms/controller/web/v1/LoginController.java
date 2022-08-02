package uz.namangan.developer.rms.controller.web.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.namangan.developer.rms.model.user.User;
import uz.namangan.developer.rms.service.intarfaces.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView root(Model model, HttpSession session) {
        ModelAndView modelAndView=new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsernameOrEmail(auth.getName());
//        modelAndView.addObject("user",user);
//        model.addAttribute("userName", "Welcome " + user.getFirstname() + " " + user.getLastname() + " (" + user.getEmail() + ")");
//        model.addAttribute("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");

        modelAndView.setViewName("index");
        return modelAndView;

    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


}
