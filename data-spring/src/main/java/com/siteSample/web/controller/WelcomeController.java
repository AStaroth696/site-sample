package com.siteSample.web.controller;

import com.sitesample.service.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/")
    public String welcome(Model model){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication());
        model.addAttribute("users", userDao.getAll());
        return "index";
    }
}
