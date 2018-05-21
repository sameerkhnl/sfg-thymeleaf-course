package guru.springframework.controllers;

import guru.springframework.domains.LoginCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("loginCommand", new LoginCommand());
        return "loginform";
    }

    //@RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String dologin(@Valid LoginCommand loginCommand, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "loginform";
        }
        return "redirect:/index";
    }

    @GetMapping("/logout-success")
    public String logout(){
        return "logout-success";
    }

    @RequestMapping("/secured")
    public String secured(){
        return "secured";
    }
}
