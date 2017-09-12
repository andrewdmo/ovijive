package com.ovijive.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class EthAccountService {

    private static Client client = ClientBuilder.newClient();


    public static String getAccountBalance(String address) throws Exception {

        return retrieveBalance(address);
    }

    private static String retrieveBalance(String address) {

        Response walletResponse = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?jsonrpc=2.0&method=eth_getBalance&params=%5B%220x85afad1a07d70bcb3850250b6a0903ce231dcbfd%22%2C%20%22latest%22%5D&id=1")
//        Response response = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?params=" + "\"" + address + "\", " + "\"latest\"")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        Response walletResponse2 = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?jsonrpc=2.0&method=eth_getBalance&params=%5B%220x66f670357f976de7e434d1ed79ee13cb27b54806%22%2C%20%22latest%22%5D&id=1")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        //comes out as: {"jsonrpc":"2.0","id":1,"result":"0x222489bf90d0df200"}
//        return walletResponse.readEntity(String.class);


        return walletResponse.readEntity(String.class) + walletResponse2.readEntity(String.class);

    }
}