package com.ovijive.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.*;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerResponse extends Response {


    //Currency pair base:
    private String base;
    //Currency pair quote:
    private String quote;
    //Bid at the exchange with the most volume:
    private Double bid;
    //Ask at the exchange with the most volume:
    private Double ask;
    //Exchange with the most volume:
    private String exchange;
    //Volume at the exchange with the most volume:
    private Double volume;
    //Number of exchanges queried:
    private int num_exchanges;
    //Total volume across all exchanges queried:
    private Double total_volume;
    //Unix timestamp:
    private int timestamp;

    public TickerResponse() {
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public StatusType getStatusInfo() {
        return null;
    }

    @Override
    public Object getEntity() {
        return null;
    }

    @Override
    public <T> T readEntity(Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T readEntity(GenericType<T> genericType) {
        return null;
    }

    @Override
    public <T> T readEntity(Class<T> aClass, Annotation[] annotations) {
        return null;
    }

    @Override
    public <T> T readEntity(GenericType<T> genericType, Annotation[] annotations) {
        return null;
    }

    @Override
    public boolean hasEntity() {
        return false;
    }

    @Override
    public boolean bufferEntity() {
        return false;
    }

    @Override
    public void close() {

    }

    @Override
    public MediaType getMediaType() {
        return null;
    }

    @Override
    public Locale getLanguage() {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public Set<String> getAllowedMethods() {
        return null;
    }

    @Override
    public Map<String, NewCookie> getCookies() {
        return null;
    }

    @Override
    public EntityTag getEntityTag() {
        return null;
    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public Date getLastModified() {
        return null;
    }

    @Override
    public URI getLocation() {
        return null;
    }

    @Override
    public Set<Link> getLinks() {
        return null;
    }

    @Override
    public boolean hasLink(String s) {
        return false;
    }

    @Override
    public Link getLink(String s) {
        return null;
    }

    @Override
    public Link.Builder getLinkBuilder(String s) {
        return null;
    }

    @Override
    public MultivaluedMap<String, Object> getMetadata() {
        return null;
    }

    @Override
    public MultivaluedMap<String, String> getStringHeaders() {
        return null;
    }

    @Override
    public String getHeaderString(String s) {
        return null;
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

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public int getNum_exchanges() {
        return num_exchanges;
    }

    public void setNum_exchanges(int num_exchanges) {
        this.num_exchanges = num_exchanges;
    }

    public Double getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(Double total_volume) {
        this.total_volume = total_volume;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}