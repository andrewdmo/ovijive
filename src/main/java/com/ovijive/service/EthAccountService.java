package com.ovijive.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class EthAccountService {

    private static Client client = ClientBuilder.newClient();

    @Bean
    public static String getAccountBalance(String address) throws Exception {

        return retrieveBalance(address);
    }

    //these should be just one once addresses entered:

    //    @Bean
    private static String retrieveBalance(String address) {

        Response walletResponse = client.target(address)
//        Response response = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?params=" + "\"" + address + "\", " + "\"latest\"")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        return walletResponse.readEntity(String.class);
    }

//    @Bean
//    private static String retrieveBalance2(String address2) {
//
//
//        Response walletResponse2 = client.target(address2)
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();
//
//        return walletResponse2.readEntity(String.class);


    //comes out as: {"jsonrpc":"2.0","id":1,"result":"0x222489bf90d0df200"}
//        return walletResponse.readEntity(String.class);

}
