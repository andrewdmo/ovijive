package com.ovijive.service;

import com.ovijive.entities.EthBtcFull;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.ovijive.beans.WalletBalances.wallet1;
import static com.ovijive.beans.WalletBalances.wallet2;
import static com.ovijive.service.livePriceService.tickerResponseFull;

@Service
public class InfuraApiService {

//    @Autowired
//    private InfRequest infRequest;

    public InfuraApiService() {
        String baseApiUrl = "\"https://api.infura.io/v1/";
    }


    //pub-private :
    public Model pingInfura(Model model) throws Exception {
        return updateInf(model);
    }

    private Model updateInf(Model model) throws Exception {
        Client client = ClientBuilder.newClient();

        //ETH-U$D full list exchange rate:
        //messy String from JSON:
//        String ethUsd = tickerResponseFull(client, "ethusd").readEntity(String.class);


        //ETH-BTC full list exchange rate:
//        String ethBtc = tickerResponseFull(client, "ethbtc").readEntity(String.class);

        EthBtcFull ethBtcFull = tickerResponseFull("ethbtc").readEntity(EthBtcFull.class);

//        Client ethUsdFull = tickerResponseFull("ethusd");


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
//        System.out.println("ethUsd: " + ethUsdFull.getTickers);
        System.out.println("ethBtc: " + ethBtcFull.getTickers());

        //for MVC:
        model.addAttribute("status", web3ClientVersion.getStatus());
        model.addAttribute("webVersion", web3ClientVersion);
        model.addAttribute("headers", web3ClientVersion.getHeaders());
//        model.addAttribute("etcUsd", ethUsdFull);
        model.addAttribute("etcBtc", ethBtcFull.toString());
        model.addAttribute("wallet1", wallet1());
        model.addAttribute("wallet2", wallet2());

        model.addAttribute("timeStamp", "4:20");

        return model;
    }
}