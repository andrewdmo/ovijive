package com.clash.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class EthAccountService {

    static String getAccountBalance(String address) throws Exception {

        Client client = ClientBuilder.newClient();

        Response response = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?jsonrpc=2.0&method=eth_getBalance&params=%5B%220x85afad1a07d70bcb3850250b6a0903ce231dcbfd%22%2C%20%22latest%22%5D&id=1")
//        Response response = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?params=" + "\"" + address + "\", " + "\"latest\"")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        return response.readEntity(String.class);

    }
}