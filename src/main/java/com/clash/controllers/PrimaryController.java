package com.clash.controllers;

import com.clash.service.InfuraApiService;
import com.clash.service.Web3jCourier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrimaryController {

    private InfuraApiService infPing = new InfuraApiService();

    @RequestMapping(value = {"", "/", "/index"})
    public String index(Model model) throws Exception {

        //CHANGE MANUALLY TO SWITCH (URL still works):
//        Web3jCourier.pingWeb3j(model);
        infPing.pingInfura(model);
        return "index";
    }

    //for testing:
//    @RequestMapping(value = {"/infura", "/infuradash", "/infuradashboard"})
//    public String infura(Model model) throws Exception {
////        InfuraApiService ping = new InfuraApiService();
//        infPing.pingInfura(model);
//
//        return "index";
//    }

    @RequestMapping(value = {"/web3jdashboard", "/web3jdash", "/web3j"})
    public String web3j(Model model) throws Exception {
        Web3jCourier.pingWeb3j(model);
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

    //    Move to ExceptionController:
//    @ExceptionHandler
//    public String error(Exception e) {
//        return "error";
//    }

}

