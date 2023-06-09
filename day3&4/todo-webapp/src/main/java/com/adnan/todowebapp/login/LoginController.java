package com.adnan.todowebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;
    
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String goToLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if(!authenticationService.authenticate(name, password)) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        return "redirect:/";
    }

}
