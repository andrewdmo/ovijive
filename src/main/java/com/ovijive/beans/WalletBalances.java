package com.ovijive.beans;

import org.springframework.context.annotation.Bean;

import static com.ovijive.service.EthAccountService.getAccountBalance;


public class WalletBalances {

    private String wallet1;
    private String wallet2;


    @Bean
    public static String wallet1() throws Exception {
        return getAccountBalance("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?jsonrpc=2.0&method=eth_getBalance&params=%5B%220x85afad1a07d70bcb3850250b6a0903ce231dcbfd%22%2C%20%22latest%22%5D&id=1");
    }

    @Bean
    public static String wallet2() throws Exception {
        return getAccountBalance("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?jsonrpc=2.0&method=eth_getBalance&params=%5B%220x66f670357f976de7e434d1ed79ee13cb27b54806%22%2C%20%22latest%22%5D&id=1");
    }


}

//        @Bean
//        Response wallet1 = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?jsonrpc=2.0&method=eth_getBalance&params=%5B%220x85afad1a07d70bcb3850250b6a0903ce231dcbfd%22%2C%20%22latest%22%5D&id=1")
////        Response response = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?params=" + "\"" + address + "\", " + "\"latest\"")
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();
//    }

//    @Bean
//    public void wallet2() {
//
//        Response walletResponse2 = client.target("https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?jsonrpc=2.0&method=eth_getBalance&params=%5B%220x66f670357f976de7e434d1ed79ee13cb27b54806%22%2C%20%22latest%22%5D&id=1")
//            .request(MediaType.APPLICATION_JSON_TYPE)
//            .header("Accept", "application/json")
//            .get();
//    }
//
//    @Bean
//    public void wallet3() {
//
//    }

//}