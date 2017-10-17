package com.ovijive.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerResponseFull {

    //Currency pair base:
    private String base;
    //Currency pair quote:
    private String quote;
    //Bid at the exchange with the most volume:
    private Tickers[] tickers;

    public TickerResponseFull() {
    }

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