package com.ovijive.service;

import com.google.gson.Gson;
import com.ovijive.entities.WalletResponse;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class EthWalletService {

    private final static Client client = ClientBuilder.newClient();

    public EthWalletService() {
    }

    public static WalletResponse getWalletBalance(String address) throws Exception {

        return retrieveBalance(address);
    }

    //these should be just one once addresses entered:

    private static WalletResponse retrieveBalance(String walletUrl) throws Exception {

//        Response walletResponse = client.target(address)
//        Response walletResponse = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?params=" + "\"" + address + "\", " + "\"latest\"")
//        Response walletResponse = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?params=" + address + "latest")
        Response walletResponse = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?params=" + walletUrl + "&latest")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();
        Gson gson = new Gson();
        return gson.fromJson(walletResponse.readEntity(String.class), WalletResponse.class);

//        try {
//            Gson gson = new Gson();
//            return gson.fromJson(walletResponse.readEntity(String.class), WalletResponse.class);
//        } catch (IllegalStateException | JsonSyntaxException exception) {
//            return null;
//        }

    }
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