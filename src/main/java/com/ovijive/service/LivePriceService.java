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

    public static Response tickerService(String symbol) throws Exception {
        Client client = ClientBuilder.newClient();

        Response tickerClientResponse = client.target("https://api.infura.io/v1/ticker/" + symbol)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        System.out.println(tickerClientResponse.toString());


        System.out.println(tickerClientResponse.readEntity(String.class));

        Gson gson = new Gson();

        System.out.println(tickerClientResponse.getEntity());


//        String jsonString = gson.fromJson(tickerClientResponse);
//        System.out.println(jsonString);

//        TickerResponseFull json = gson.fromJson(tickerClientResponse.toString(), TickerResponseFull.class);
//        System.out.println(json);

//        return json;

        return null;
    }

    // web3j uses:
    public static Response tickerServiceFull(String symbol) throws Exception {

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

        String jsonString = tickerClientResponseFull.toString();

        TickerResponseFull json = gson.fromJson(jsonString, TickerResponseFull.class);


        //deserializes:
//        TickerResponseFull tickerResponseFull2 = gson.fromJson(json, TickerResponseFull.class);

        System.out.println(json);
//        System.out.println(tickerClientResponseFull.getEntity().toString());
//        return gson.fromJson(tickerClientResponseFull, Response.class);
        return tickerClientResponseFull;
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