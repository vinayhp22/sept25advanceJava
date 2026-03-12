package com.skyllx.sppring_security_demo.controller;

import com.skyllx.sppring_security_demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private LoginService service;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(String username, String password, Model model){
        String token =  service.authenticateAndGenerateToken(username, password);
        if (token!=null && !token.isEmpty()){
            model.addAttribute("token", token);
            return "home";
        } else {
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
