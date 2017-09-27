package com.ovijive.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class livePriceService {

    // web3j uses:
    public static Response tickerResponse(String symbol) throws Exception {

        Client client = ClientBuilder.newClient();

        return client.target("https://api.infura.io/v1/ticker/" + symbol)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();
    }

    // just one exchange:
    public static Response tickerResponseShort(String symbol) throws Exception {

        Client client = ClientBuilder.newClient();

        return client.target("https://api.infura.io/v1/ticker/" + symbol)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();
    }
}