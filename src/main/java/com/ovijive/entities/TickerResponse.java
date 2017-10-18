package com.ovijive.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerResponse {

    //Currency pair base:
    private String base;
    //Currency pair quote:
    private String quote;
    //Bid at the exchange with the most volume:
    private Long bid;
    //Ask at the exchange with the most volume:
    private Long ask;
    //Exchange with the most volume:
    private String exchange;
    //Volume at the exchange with the most volume:
    private Long volume;
    //Number of exchanges queried:
    private int num_exchanges;
    //Total volume across all exchanges queried:
    private Long total_volume;
    //Unix timestamp:
    private int timestamp;

    public TickerResponse() {
    }

    //custom Gs & Ss:
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

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getAsk() {
        return ask;
    }

    public void setAsk(Long ask) {
        this.ask = ask;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public int getNum_exchanges() {
        return num_exchanges;
    }

    public void setNum_exchanges(int num_exchanges) {
        this.num_exchanges = num_exchanges;
    }

    public Long getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(Long total_volume) {
        this.total_volume = total_volume;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}