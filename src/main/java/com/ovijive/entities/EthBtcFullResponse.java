package com.ovijive.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EthBtcFullResponse {

    private String base;
    private String quote;
    private Tickers[] tickers;
//
//    public EthBtcFullResponse() {
//    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Tickers[] getTickers() {
        return tickers;
    }

    public void setTickers(Tickers[] tickers) {
        this.tickers = tickers;
    }
}