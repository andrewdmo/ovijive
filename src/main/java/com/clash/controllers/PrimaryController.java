package com.clash.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.infura.InfuraHttpService;

import java.util.concurrent.ExecutionException;

@Controller
public class PrimaryController {


    @RequestMapping(value = {"", "/", "/index"})
    public String index(Model model) throws ExecutionException, InterruptedException {

        Web3j web3 = Web3j.build(new InfuraHttpService("https://ropsten.infura.io/KH92iLaeW68rq2EQBiSC"));
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
        String webVersion = web3ClientVersion.getWeb3ClientVersion();

        model.addAttribute("web3", web3);
        model.addAttribute("webVersion", webVersion);
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
    //add URL request query feedback later:
    public String error() {

        return "error";
    }

}

