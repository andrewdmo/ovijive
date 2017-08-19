package com.clash.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PrimaryController {


    @RequestMapping(value = {"", "/", "/index"})
    public String index(@RequestParam(value = "name", required = false, defaultValue = "") String name, Model
        model) {
        model.addAttribute("name", name);
        return "index";
    }

    // maybe change name later for protection:
    // GET/POST handled by Spring Sec.
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    //secured:
    @RequestMapping(value = {"/usersecurespace", "/user/usersecurespace"})
    public String usersecurespace() {
        return "user/usersecurespace";
    }


    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    //    Move to ExceptionController:
    @ExceptionHandler
    //add URL request query feedback later:
    public String error() {
        return "error";
    }

}

