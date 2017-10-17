package com.ovijive.service;

import com.google.gson.Gson;
import com.ovijive.entities.TickerResponseFull;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class LivePriceService {


    public LivePriceService() {
    }

//    public static Response tickerService(String symbol) throws Exception {
//
//        //web3j HTTP (get JSON):
//        Client client = ClientBuilder.newClient();
//        Response ethBtc = client.target("https://api.infura.io/v1/ticker/" + symbol)
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();
//
//
//        //serializes to Json:
//        Gson gson = new Gson();
//        TickerResponse tickerResponse = new TickerResponse();
//        String json = gson.toJson(tickerResponse, TickerResponse.class);
//        //deserializes:
//        TickerResponse tickerResponse2 = gson.fromJson(tickerResponse, TickerResponse.class);
//
//
//        //console:
//        String clientOutput = ethBtc.toString();
//        String gsonOutput = tickerResponse2.toString();
//        System.out.println("clientResponseOutput:" + clientOutput);
//        System.out.println("GsonResponseOutput:" + tickerResponse2);
//
//        return tickerResponse2;
////        return ethBtc;
//    }

    // web3j uses:
    public static TickerResponseFull tickerServiceFull(String symbol) throws Exception {

//      //web3j HTTP (get JSON):
        Client client = ClientBuilder.newClient();
//        InfResponse infResponse = new InfResponse();
        Response tickerClientResponseFull = client.target("https://api.infura.io/v1/ticker/" + symbol + "/full")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

//      //serializes to Json:
        Gson gson = new Gson();
//        TickerResponseFull tickerResponseFull = new TickerResponseFull();
        String json = gson.toJson(tickerClientResponseFull);
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();
        //deserializes:
//        TickerResponseFull tickerResponseFull2 = gson.fromJson(json, TickerResponseFull.class);


        return gson.fromJson(json, TickerResponseFull.class);
//        return ethBtcFull;
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