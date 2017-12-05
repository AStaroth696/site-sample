package com.siteSample.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/")
    public String welcome(Model model){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication());
        return "index";
    }
}
