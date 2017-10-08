package com.ovijive.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ovijive.entities.TickerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.ovijive.service.LivePriceService.tickerResponse;

import java.io.IOException;

public class TickerMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public TickerResponse tickerMapper() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TickerResponse tickerResponse = objectMapper.readValue(tickerResponse("ethbtc"), TickerResponse.class);
        logger.info(tickerResponse.toString());
        return tickerResponse;
    }
}