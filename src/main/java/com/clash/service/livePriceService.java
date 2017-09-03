package com.clash.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class livePriceService {

    public static Response tickerResponse(String symbol)throws Exception {

        Client client = ClientBuilder.newClient();

        return client.target("https://api.infura.io/v1/ticker/" + symbol)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();
    }
}