package com.clash.controllers;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class InfuraApiCourier {

    //pub-private :
    public static void update(Model model) throws Exception {
        pingInfura(model);
    }


    private String pingInfura(Model model) throws Exception {

        Client client = ClientBuilder.newClient();
        Response response = client.target("https://api.infura.io/v1/ticker/ethbtc")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        model.addAttribute("response", response);

        //from example:
        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));

        return "index";
    }

}