package uz.namangan.developer.rms.controller.web.v1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String home(){
//        ModelAndView model = new ModelAndView();
//        model.setViewName("index");
        return "redirect:login";
    }
    @GetMapping( "/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value= {"/home"}, method=RequestMethod.GET)
    public ModelAndView home2() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }


}
