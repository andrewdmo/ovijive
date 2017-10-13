package com.ovijive.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.ws.rs.core.*;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerResponseFull extends Response {

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

    public TickerResponseFull() {
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

    //regular Response Gs & Ss:
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