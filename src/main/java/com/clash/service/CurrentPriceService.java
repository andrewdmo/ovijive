//package com.clash.service;
//
////import javax.ws.rs.client.Client;
////import javax.ws.rs.client.ClientBuilder;
////import javax.ws.rs.client.Entity;
////import javax.ws.rs.core.Response;
////import javax.ws.rs.core.MediaType;
////
////Client client = ClientBuilder.newClient();
////    Response response = client.target("https://api.infura.io/v1/ticker/{symbol}")
////    .request(MediaType.APPLICATION_JSON_TYPE)
////    .header("Accept", "application/json")
////    .get();
////
////    System.out.println("status: " + response.getStatus());
////    System.out.println("headers: " + response.getHeaders());
////    System.out.println("body:" + response.readEntity(String.class));
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//public class CurrentPriceService{
//
//    Client client = ClientBuilder.newClient();
//    Response response = client.target("https://api.infura.io/v1/ticker/{symbol}")
//    .request(MediaType.APPLICATION_JSON_TYPE)
//    .header("Accept", "application/json")
//    .get();
//
//    System.out.println("status: " + response.getStatus());
//    System.out.println("headers: " + response.getHeaders());
//    System.out.println("body:" + response.readEntity(String.class));
//
//}