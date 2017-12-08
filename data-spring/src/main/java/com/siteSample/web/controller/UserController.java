package com.siteSample.web.controller;

import com.siteSample.web.auth.UserAuthDetailService;
import com.sitesample.service.dao.UserDao;
import com.sitesample.service.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model){
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registerProcess(@RequestParam("name") String name,
                                  @RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  @RequestParam("passwordConfirm") String passwordConfirm,
                                  Model model){
        List<String> errors = new ArrayList<>();
        if (StringUtils.isEmpty(name)){
            errors.add("Name cannot be empty");
        }else if (userDao.findByName(name) != null){
            errors.add("User with this name already exists");
        }

        if (StringUtils.isEmpty(email)){
            errors.add("Email cannot be empty");
        }else if (userDao.findByEmail(email) != null){
            errors.add("User with this email already exists");
        }

        if (StringUtils.isEmpty(password)){
            errors.add("Password cannot be empty");
        }

        if (!StringUtils.equals(password, passwordConfirm)){
            errors.add("Password and confirmation doesn`t match");
        }

        if (errors.size()>0){
            model.addAttribute("errors", errors);
            model.addAttribute("name", name);
            return "register";
        }else {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            userDao.create(user);

            return "forward:login";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model){
        if (error != null){
            model.addAttribute("error", "Invalid username or password");
        }
        if (logout != null){
            model.addAttribute("logout", "You`ve been logged out succesfuly");
        }
        return "login";
    }



}
