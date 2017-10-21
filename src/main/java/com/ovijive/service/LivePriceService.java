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
public class LivePriceService {


    public LivePriceService() {
    }

    public static TickerResponse tickerService(String symbol) throws Exception {
        Client client = ClientBuilder.newClient();

        Response tickerClientResponse = client.target("https://api.infura.io/v1/ticker/" + symbol)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

//        Object tickerResponse = tickerClientResponse.getEntity();

        String tickerResponse = tickerClientResponse.readEntity(String.class);

        System.out.println(tickerResponse);

//        TickerResponse tickerResponse = tickerClientResponse.readEntity(TickerResponse.class);

        //data tests:
        System.out.println("tickerResponse.readEntity(TR.class): " + tickerResponse);
        System.out.println("tickerResponse.readEntity(TR.class).toString: " + tickerResponse.toString());

        Gson gson = new Gson();

        TickerResponse tixResponse = gson.fromJson(tickerResponse, TickerResponse.class);
//        String requestOut = gson.toJson("https://api.infura.io/v1/ticker/" + symbol);

//        String requestIn = gson.fromJson("https://api.infura.io/v1/ticker/" + symbol);
//        JsonReader reader = new JsonReader(requestOut);
//        JsonReader reader = new JsonReader(new StringReader(tickerClientResponse.toString()));
//        reader.setLenient(true);

        System.out.println("response.toString: " + tickerClientResponse.toString());

//        System.out.println("response.readEntity: " + tickerClientResponse.readEntity(String.class));


//        System.out.println("response_reader.readEntity(String.class): " + reader);
//
//
//        TickerResponse tickerResponse = gson.fromJson(reader, TickerResponse.class);
//        System.out.println("response.raw: " + tickerResponse);
//
//
//        String tickerResponseStr = gson.fromJson(tickerClientResponse.toString(), String.class);
//        System.out.println("response.toString: " + tickerResponseStr);

//        String jsonString = gson.fromJson("https://api.infura.io/v1/ticker/" + symbol + "/", String.class);
//        System.out.println("GSon string: " + jsonString);


//        Response jsonString2 = gson.fromJson("https://api.infura.io/v1/ticker/" + symbol + "/", Response.class);
//        System.out.println("TixResponse string: " + jsonString2.toString());

//        TickerResponseFull json = gson.fromJson(tickerClientResponse.toString(), TickerResponseFull.class);
//        System.out.println(json);

//        return json;

        return tixResponse;
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