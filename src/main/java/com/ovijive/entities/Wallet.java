package com.ovijive.entities;

public class Wallet {

//    public Wallet wallet = new Wallet();

    public String walletName;
    public String walletAddress;
    private String walletBalance;

//    public Wallet getWallet() {
//        return wallet;
//    }
//
//    public void setWallet() {
//        this.wallet = wallet;
//    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getWalletBalance() {
        return walletBalance;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance;
    }
}