package com.ovijive.service;

import com.google.gson.Gson;
import com.ovijive.entities.TickerResponse;
import com.ovijive.entities.TickerResponseFull;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class LiveTickerService {

    public LiveTickerService() {
    }

    //endpoint w/ price --only at exchange with most volume-- for given symbol:
    static TickerResponse tickerService(String symbol) throws Exception {

        final Client client = ClientBuilder.newClient();

        //holler @ Ete
//        Response tickerClientResponse = client.target("mainnet.infura.io/v3/daf9d1065e9549ed9be88627109d0a25/" + symbol)
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();

//      OLD ROPSTEN / TEST: (works 4/19)
        Response tickerClientResponse = client.target("https://api.infura.io/v1/ticker/" + symbol)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        //debug string;
        System.out.println("response.toString: " + tickerClientResponse.toString());

        //sideline for production, closes Response instance if not an input stream:
//        String tickerResponse = tickerClientResponse.readEntity(String.class);
//        System.out.println(tickerClientResponse.readEntity(String.class));

        //custom (Ticker)Response from String:
        Gson gson = new Gson();
        return gson.fromJson(tickerClientResponse.readEntity(String.class), TickerResponse.class);
    }

    //all exchanges:
    static TickerResponseFull tickerServiceFull(String symbol) throws Exception {

        final Client client = ClientBuilder.newClient();

        Response tickerClientResponseFull = client.target("https://api.infura.io/v1/ticker/" + symbol + "/full")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        //debug string to console;
//        System.out.println("responseFull.toString: " + tickerClientResponseFull.toString());

//      //serializes to Json:
        Gson gson = new Gson();

//        System.out.println("tickerClientResponseFull.getEntity().toString:: " + tickerClientResponseFull.getEntity().toString());

//        return null;
        return gson.fromJson(tickerClientResponseFull.readEntity(String.class), TickerResponseFull.class);

    }

}