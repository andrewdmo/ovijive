package com.clash.controllers;

import com.clash.service.CurrentPriceService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.infura.InfuraHttpService;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Service
public class EthCourier {

    //pub-private :
    public static void update(Model model) throws Exception {
        dashInfo(model);
    }

    @RequestMapping(value = {"/dashboard", "/dash"})
    private static String dashInfo(Model model) throws Exception {

        // instantiate request for unique (Ropsten test) Infura node:
        Web3j web3 = Web3j.build(new InfuraHttpService("https://ropsten.infura.io/KH92iLaeW68rq2EQBiSC"));

        // Test Wallet 1 (from MyEthereumWallet):
/*
        Web3j web3one = Web3j.build(new HttpService("https:.//ropsten.infura.io/KH92iLaeW68rq2EQBiSC"));  // defaults to http://localhost:8545/
        Credentials credentials1 = WalletUtils.loadCredentials("ruhrahrega", "~/Downloads/testWallet1");
        TransactionReceipt transactionReceipt1 = Transfer.sendFunds(
            web3one, credentials1, "0x66f670357f976de7e434d1ed79ee13cb27b54806", BigDecimal.valueOf(1.0), Convert.Unit.ETHER);
*/

        // Test Wallet 2 (from MyEthereumWallet):
//        Web3j web3two = Web3j.build(new HttpService("https:.//ropsten.infura.io/KH92iLaeW68rq2EQBiSC"));  // defaults to http://localhost:8545/
//        Credentials credentials2 = WalletUtils.loadCredentials("ruhrahrega", "~/Downloads/testWallet2");
//        TransactionReceipt transactionReceipt2 = Transfer.sendFunds(
//            web3two, credentials2, "85afad1a07d70bcb3850250b6a0903ce231dcbfd", BigDecimal.valueOf(2.0), Convert.Unit.ETHER);

        // a-sync version:
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
        String webVersion = web3ClientVersion.getWeb3ClientVersion();

        // sync version:
        Web3ClientVersion web3ClientVersionSync = web3.web3ClientVersion().send();
        String webVersionSync = web3ClientVersionSync.getWeb3ClientVersion();

        //ticker, symbol changeable:
        Response response = CurrentPriceService.response("ethbtc");
        int status = response.getStatus();
        MultivaluedMap<String, Object> header = response.getHeaders();
        String body = response.readEntity(String.class);


//        System.out.println("status: " + response.getStatus());
//        System.out.println("headers: " + response.getHeaders());
//        System.out.println("body:" + response.readEntity(String.class));

        model.addAttribute("webVersion", webVersion);
        model.addAttribute("webVersionSync", webVersionSync);
        model.addAttribute("status", status);
        model.addAttribute("headers", header);
        model.addAttribute("body", body);
        return "index";

    } //String update()
}