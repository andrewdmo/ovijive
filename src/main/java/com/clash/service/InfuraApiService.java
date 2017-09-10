package com.clash.service;

import com.clash.beans.RequestBean;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.clash.beans.RequestBean.addAttribute;
import static com.clash.beans.WalletBalances.wallet1;
import static com.clash.beans.WalletBalances.wallet2;


@Service
public class InfuraApiService {

    RequestBean requestBean = new RequestBean();

    public InfuraApiService() {

    }

//    WalletBalances walletBalances = new WalletBalances();

    //pub-private :
    public static RequestBean pingInfura() throws Exception {
        RequestBean requestBean = new RequestBean();
        requestBean = update(requestBean);
        return requestBean;
    }


    private static RequestBean update(RequestBean requestBean) throws Exception {

        Client client = ClientBuilder.newClient();


        Response etcBtcTickerResponse = client.target("https://api.infura.io/v1/ticker/ethbtc")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

        String body = etcBtcTickerResponse.readEntity(String.class);

        Response web3ClientVersion = client.target("http://api.infura.io/v1/jsonrpc/ropsten/web3_clientVersion")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Accept", "application/json")
            .get();

//        early trial:
//        String wallet1 = EthAccountService.getAccountBalance("0x85afad1a07d70bcb3850250b6a0903ce231dcbfd");


        //console:
        System.out.println("status: " + web3ClientVersion.getStatus());
        System.out.println("headers: " + web3ClientVersion.getHeaders());
        System.out.println("body:" + body);

        addAttribute("status", web3ClientVersion.getStatus());
        addAttribute("webVersion", web3ClientVersion);
        addAttribute("headers", web3ClientVersion.getHeaders());
        addAttribute("body", body);
        addAttribute("wallet1", wallet1());
        addAttribute("wallet2", wallet2());


        return requestBean;
    }

}
