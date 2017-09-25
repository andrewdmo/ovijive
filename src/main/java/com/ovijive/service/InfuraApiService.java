package com.ovijive.service;

import com.ovijive.beans.InfRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.ovijive.beans.WalletBalances.wallet1;
import static com.ovijive.beans.WalletBalances.wallet2;

@Service
public class InfuraApiService {

    @Autowired
    private InfRequest infRequest;

    public InfuraApiService() {

        String baseApiUrl = "\"https://api.infura.io/v1/";
    }


    //pub-private :
    public Model pingInfura(Model model) throws Exception {

        return updateInf(model, infRequest);
    }

    private Model updateInf(Model model, InfRequest infRequest) throws Exception {
//        this.model = model;
        Client client = ClientBuilder.newClient();


        Response ethUsdTickerResponse = client.target("https://api.infura.io/v1/ticker/ethusd")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        String ethUsd = ethUsdTickerResponse.readEntity(String.class);

        //Eth-Btc exchange rate:
        Response ethBtcTickerResponse = client.target("https://api.infura.io/v1/ticker/ethbtc")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        String ethBtc = ethBtcTickerResponse.readEntity(String.class);

        //client version / TEST:
        Response web3ClientVersion = client.target("http://api.infura.io/v1/jsonrpc/ropsten/web3_clientVersion")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

//        early trial:
//        String wallet1 = EthAccountService.getAccountBalance("0x85afad1a07d70bcb3850250b6a0903ce231dcbfd");

        //console:
        System.out.println("status: " + web3ClientVersion.getStatus());
        System.out.println("headers: " + web3ClientVersion.getHeaders());
        System.out.println("ethUsd:" + ethUsd);
        System.out.println("ethBtc:" + ethBtc);

        //for MVC:
        model.addAttribute("status", web3ClientVersion.getStatus());
        model.addAttribute("webVersion", web3ClientVersion);
        model.addAttribute("headers", web3ClientVersion.getHeaders());
        model.addAttribute("etcUsd", ethUsd);
        model.addAttribute("etcBtc", ethBtc);
        model.addAttribute("wallet1", wallet1());
        model.addAttribute("wallet2", wallet2());

        model.addAttribute("timeStamp", "4:20");

        return model;
    }
}
