package com.ovijive.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.ovijive.service.InfuraApiService.pingInfura;

@Controller
public class PrimaryController {

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) throws Exception {
        pingInfura(model);
        return "index";
    }

    // maybe change name later for protection:
    // GET/POST handled by Spring Sec.
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //secured:
    @RequestMapping(value = {"/usersecurespace", "/user/usersecurespace"})
    public String usersecurespace() {
        return "user/usersecurespace";
    }


    @RequestMapping("/web3")
    public String web3() {
        return "web3";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    //    Move to ExceptionController:
//    @ExceptionHandler
//    public String error(Exception e) {
//        return "error";
//    }

}

