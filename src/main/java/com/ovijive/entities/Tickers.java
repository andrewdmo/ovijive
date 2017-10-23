package com.ovijive.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties
public class Tickers {

    private Double bid;
    private Double ask;
    private Double volume;
    private int timestamp;
    private String exchange;

    public Tickers() {
    }


    @Override
    public String toString() {
        return "Bid: " + this.bid + ", Ask: " + this.ask + ", Volume: " + this.volume + ", Timestamp: " + this.timestamp + ", Exchange: " + this.exchange;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

}