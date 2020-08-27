package it.si2001.testlogin.controller;

import it.si2001.testlogin.domain.User;
import it.si2001.testlogin.domain.UserCredential;
import it.si2001.testlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    public void setUserService(UserService studentService) {
        this.userService = studentService;
    }

    public UserService getUserService() {
        return userService;
    }



    @RequestMapping(value ="/" ,method=RequestMethod.GET)
    public String loginPage(Model model){
        model.addAttribute("userCredential", new UserCredential());
        return "login";
    }



    @RequestMapping(value ="/loginSuccess" ,method= RequestMethod.POST)
    public ModelAndView loginSuccess(@Valid @ModelAttribute("userCredential") UserCredential userCredential, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("login");
        }

        ModelAndView modelAndView = new ModelAndView("welcome");
        User user = getUserService().checkUser(userCredential.getEmail(), userCredential.getPassword());
        if(user!= null){
            modelAndView.addObject("loggato", user);
            return modelAndView;
        }else{
            modelAndView = new ModelAndView("notFound");
        }
        return modelAndView;
    }


}
