package com.clash.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class InfuraApiCourier {

    //pub-private :
    public static Model pingInfura(Model model) throws Exception {
        update(model);
        return model;
    }


    private static Model update(Model model) throws Exception {

        Client client = ClientBuilder.newClient();

        Response etcBtcTickerResponse = client.target("https://api.infura.io/v1/ticker/ethbtc")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        String body = etcBtcTickerResponse.readEntity(String.class);

        Response web3ClientVersion = client.target("http://api.infura.io/v1/jsonrpc/ropsten/web3_clientVersion")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

//        Response getHeaders = client.target("http://api.infura.io/v1/jsonrpc/ropsten/web3_clientVersion")
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();

        //console:
        System.out.println("status: " + web3ClientVersion.getStatus());
        System.out.println("headers: " + web3ClientVersion.getHeaders());
        System.out.println("body:" + body);

        model.addAttribute("status", web3ClientVersion.getStatus());
        model.addAttribute("webVersion", web3ClientVersion);
        model.addAttribute("headers", web3ClientVersion.getHeaders());
        model.addAttribute("body", body);

        return model;
    }

}