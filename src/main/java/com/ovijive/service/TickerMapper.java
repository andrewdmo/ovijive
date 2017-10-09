//package com.ovijive.service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.ws.rs.core.Response;
//
//import static com.ovijive.service.LivePriceService.tickerResponse;
//
//public class TickerMapper {
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    public Response tickerMapObj() throws Exception {
//
//        tickerResponse()
//        ObjectMapper objectMapper = new ObjectMapper();
//        Response tickerResponse = objectMapper.readValue();
//        logger.info(tickerResponse.toString());
//        return tickerResponse;
//    }
//}