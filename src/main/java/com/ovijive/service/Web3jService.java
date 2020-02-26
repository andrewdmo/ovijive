package com.ovijive.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;


@Service
public class Web3jService {

    //pub-private :
    public static Model pingWeb3j(Model model) throws Exception {
        update(model);
        return model;
    }

    private static Model update(Model model) throws Exception {

        //        Client client = ClientBuilder.newClient();

        // instantiate request for unique (Ropsten test) Infura node:
        Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/daf9d1065e9549ed9be88627109d0a25"));


        // sync request:
        Web3ClientVersion web3ClientVersionSync = web3.web3ClientVersion().send();
        String webVersion = web3ClientVersionSync.getWeb3ClientVersion();

        // a-sync request:
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
        String webVersionAsync = web3ClientVersion.getWeb3ClientVersion();

        //ticker, symbol changeable:
//        Response response = tickerResponseFull("ethbtc");
//        int status =
//        MultivaluedMap<String, Object> header = response.getHeaders();
//        String body = response.readEntity(String.class);

//        model.addAttribute("status", status);
        model.addAttribute("webVersion", webVersion);

        model.addAttribute("webVersion", webVersionAsync);
//        model.addAttribute("headers", header);
//        model.addAttribute("body", body);

        //console:
//        System.out.println("status: " + response.getStatus());
//        System.out.println("headers: " + response.getHeaders());
//        System.out.println("body:" + body);

        return model;
    }
}