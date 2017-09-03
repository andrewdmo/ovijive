package com.clash.controllers;

import com.clash.service.InfuraApiCourier;
import com.clash.service.Web3jCourier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrimaryController {

    @RequestMapping(value = {"", "/", "/index"})
    public String index(Model model) throws Exception {
        //CHANGE MANUALLY (URL still works):
//        Web3jCourier.pingWeb3j(model);
        InfuraApiCourier.pingInfura(model);
        return "index";
    }

    @RequestMapping(value = {"/infura", "infuradash", "infuradashboard"})
    public String infura(Model model) throws Exception {
        InfuraApiCourier.pingInfura(model);
        return "index";
    }

    @RequestMapping(value = {"/web3jdashboard", "/web3jdash", "/web3j"})
    public String web3j(Model model) throws Exception {
        Web3jCourier.pingWeb3j(model);
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


    @RequestMapping("/web3")
    public String web3() {
        return "web3";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    //    Move to ExceptionController:
    @ExceptionHandler
    public String error(Exception e) {
        return "error";
    }

}
