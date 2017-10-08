package com.ovijive.service;

import com.ovijive.entities.InfRequest;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class LivePriceService {


    public LivePriceService() {
    }

    public static Response tickerResponse(String symbol) throws Exception {

        //web3j HTTP:
        Client client = ClientBuilder.newClient();
        Response ethBtc = client.target("https://api.infura.io/v1/ticker/" + symbol)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        InfRequest infRequest = new InfRequest();
        String output = ethBtc.toString();
        System.out.println("clientResponseOutput:" + output);

        return ethBtc.;
    }

    // web3j uses:
    public static Response tickerResponseFull(String symbol) throws Exception {

        //web3j HTTP:
        Client client = ClientBuilder.newClient();
//        InfResponse infResponse = new InfResponse();
        Response ethBtcFull = client.target("https://api.infura.io/v1/ticker/" + symbol + "/full")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        InfRequest infRequest = new InfRequest();
        String output = ethBtcFull.toString();
        System.out.println("clientResponseOutput:" + output);

//        return ethBtcFullHttp.getResponseHandler());

        return ethBtcFull;
    }

//        Client client = ClientBuilder.newClient();
////        EthBtcFullResponse ethBtcFullResponse = new EthBtcFullResponse();
//
//        //has to be a Response:
//         Response ethBtcFullResponse = client.target("https://api.infura.io/v1/ticker/" + symbol + "/full")
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();
////            .readEntity(EthBtcFull.class);
//return ethBtcFullResponse;

// just one exchange:
//    public static Response tickerResponseShort(String symbol) throws Exception {
//
//        Client client = ClientBuilder.newClient();
//
//        return client.target("https://api.infura.io/v1/ticker/" + symbol)
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();
//    }
}