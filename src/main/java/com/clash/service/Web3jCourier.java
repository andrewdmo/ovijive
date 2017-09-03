package com.clash.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.infura.InfuraHttpService;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Service
public class Web3jCourier {

    //pub-private :
    public static Model pingWeb3j(Model model) throws Exception {
        update(model);
        return model;
    }

    private static Model update(Model model) throws Exception {

        // instantiate request for unique (Ropsten test) Infura node:
        Web3j web3 = Web3j.build(new InfuraHttpService("https://ropsten.infura.io/KH92iLaeW68rq2EQBiSC"));

        // a-sync version:
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
        String webVersion = web3ClientVersion.getWeb3ClientVersion();

        // sync version:
        Web3ClientVersion web3ClientVersionSync = web3.web3ClientVersion().send();
        String webVersionSync = web3ClientVersionSync.getWeb3ClientVersion();

        //ticker, symbol changeable:
        Response response = CurrentPriceService.tickerResponse("ethbtc");
        int status = response.getStatus();
        MultivaluedMap<String, Object> header = response.getHeaders();
        String body = response.readEntity(String.class);

        model.addAttribute("status", status);
        model.addAttribute("webVersion", webVersion);
        model.addAttribute("webVersionSync", webVersionSync);
        model.addAttribute("headers", header);
        model.addAttribute("body", body);

        //console:
        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + body);

        return model;

    }
}