package com.ovijive.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.Response;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfRequest extends Request /*implements Serializable*/ {

//    @Value()
//    public String URI;

    public InfRequest() {
    }

    public InfRequest(String method, List params, long id, Web3jService web3jService, Class type) {
        super(method, params, id, web3jService, type);
    }

    @Override
    public String getJsonrpc() {
        return super.getJsonrpc();
    }

    @Override
    public void setJsonrpc(String jsonrpc) {
        super.setJsonrpc(jsonrpc);
    }

    @Override
    public String getMethod() {
        return super.getMethod();
    }

    @Override
    public void setMethod(String method) {
        super.setMethod(method);
    }

    @Override
    public List getParams() {
        return super.getParams();
    }

    @Override
    public void setParams(List params) {
        super.setParams(params);
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public Response send() throws IOException {
        return super.send();
    }

    @Override
    public CompletableFuture sendAsync() {
        return super.sendAsync();
    }

    // not working:
//    @Override
//    public Observable observable() {
//        return super.observable();
//    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}