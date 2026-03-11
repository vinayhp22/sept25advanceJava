package com.skyllx.sppring_security_demo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(){
        return "redirect:/login.html";
    }


    @GetMapping("/home")
    public String home(){
        return "redirect:/home.html";
    }

    @GetMapping("/admin")
    public String admin(){
        return "redirect:/admin.html";
    }
}
