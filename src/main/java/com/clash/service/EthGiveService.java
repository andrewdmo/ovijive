package com.clash.service;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;

public class EthGiveService {

    Web3j web3one = Web3j.build(new HttpService("https:.//ropsten.infura.io/KH92iLaeW68rq2EQBiSC"));  // defaults to http://localhost:8545/

    public EthGiveService(Web3j web3j) throws Exception {

        // Test Wallet 1 (from MyEthereumWallet):

        Web3j web3one = Web3j.build(new HttpService("https:.//ropsten.infura.io/KH92iLaeW68rq2EQBiSC"));  // defaults to http://localhost:8545/
        Credentials credentials1 = WalletUtils.loadCredentials("ruhrahrega", "~/Downloads/testWallet1");
        TransactionReceipt transactionReceipt1 = Transfer.sendFunds(
            web3one, credentials1, "0x66f670357f976de7e434d1ed79ee13cb27b54806", BigDecimal.valueOf(1.0), Convert.Unit.ETHER);


        // Test Wallet 2 (from MyEthereumWallet):
        Web3j web3two = Web3j.build(new HttpService("https:.//ropsten.infura.io/KH92iLaeW68rq2EQBiSC"));  // defaults to http://localhost:8545/
        Credentials credentials2 = WalletUtils.loadCredentials("ruhrahrega", "~/Downloads/testWallet2");
        TransactionReceipt transactionReceipt2 = Transfer.sendFunds(
            web3two, credentials2, "0x85afad1a07d70bcb3850250b6a0903ce231dcbfd", BigDecimal.valueOf(2.0), Convert.Unit.ETHER);

    }
}


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
