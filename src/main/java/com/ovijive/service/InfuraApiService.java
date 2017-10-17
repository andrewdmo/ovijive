package com.ovijive.service;

import com.ovijive.entities.TickerResponseFull;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static com.ovijive.beans.WalletBalances.wallet1;
import static com.ovijive.beans.WalletBalances.wallet2;
import static com.ovijive.service.LivePriceService.tickerServiceFull;

@Service
public class InfuraApiService {

//    @Autowired
//    TickerResponse tickerResponse;

    public InfuraApiService() {
    }

    //pub-private :
    public static Model pingInfura(Model model) throws Exception {
        return updateInf(model);
    }

    private static Model updateInf(Model model) throws Exception {
//        Client client = ClientBuilder.newClient();

        //ETH-U$D full list exchange rate:
        //messy String from JSON:
//        String ethUsd = tickerResponseFull(client, "ethusd").readEntity(String.class);


        //ETH-BTC full list exchange rate:
//        String ethBtc = tickerResponseFull(client, "ethbtc").readEntity(String.class);

        TickerResponseFull tickerResponseFull = tickerServiceFull("ethbtc");
//        Response rawEthbtc = tickerResponseFull("ethbtc");


        String ethBtc = tickerResponseFull.toString();
//        Client ethUsdFull = tickerResponseFull("ethusd");

        String version = tickerResponseFull.getBase();
        //client version / TEST:
//        Response web3ClientVersion = client.target("http://api.infura.io/v1/jsonrpc/ropsten/web3_clientVersion")
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();

//        early trial:
//        String wallet1 = EthAccountService.getAccountBalance("0x85afad1a07d70bcb3850250b6a0903ce231dcbfd");


        //console:
//        System.out.println("ethUsd: " + ethUsdFull.getTickers);
        System.out.println("ethBtc: " + ethBtc);

        //for MVC:
//        model.addAttribute("status", tickerResponseFull.getStatus());
        model.addAttribute("webVersion", version);
//        model.addAttribute("headers", tickerResponseFull.getHeaders());
//        model.addAttribute("etcUsd", ethUsdFull);
        model.addAttribute("etcBtc", ethBtc);

//        model.addAttribute("etcBtc", tickerResponseFull.toString());
        model.addAttribute("wallet1", wallet1());
        model.addAttribute("wallet2", wallet2());

        model.addAttribute("timeStamp", "4:20");

        return model;
    }
}