package com.ovijive.beans;

import com.ovijive.entities.WalletResponse;
import org.springframework.stereotype.Service;

import static com.ovijive.service.EthWalletService.getWalletBalance;

@Service
public class WalletBalances {

    //keeping separate for now:

//    private static String wallet1Url = "https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?jsonrpc=2.0&method=eth_getBalance&params=%5B%220x85afad1a07d70bcb3850250b6a0903ce231dcbfd%22%2C%20%22latest%22%5D&id=1";
//    private static String wallet2Url = "https://api.infura.io/v1/jsonrpc/ropsten/eth_getBalance?jsonrpc=2.0&method=eth_getBalance&params=%5B%220x66f670357f976de7e434d1ed79ee13cb27b54806%22%2C%20%22latest%22%5D&id=1";

    //mod later to receive input:
    private static String wallet1Addy = "0x85afad1a07d70bcb3850250b6a0903ce231dcbfd";
    private static String wallet2Addy = "0x66f670357f976de7e434d1ed79ee13cb27b54806";
    //no 0x :
//    private static String wallet1Addy = "85afad1a07d70bcb3850250b6a0903ce231dcbfd";
//    private static String wallet2Addy = "66f670357f976de7e434d1ed79ee13cb27b54806";

    public WalletBalances() {
    }

    //eventually just need one
    public static WalletResponse wallet1() throws Exception {
        return getWalletBalance(wallet1Addy);
    }

    public static WalletResponse wallet2() throws Exception {
        return getWalletBalance(wallet2Addy);
    }

}