package com.clash.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class EthAccountService {

    public String getAccountBalance(String address, Model model) throws Exception {

        Client client = ClientBuilder.newClient();

        Response response = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?params=" + address + "&latest")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        return response.readEntity(String.class);

    }
}