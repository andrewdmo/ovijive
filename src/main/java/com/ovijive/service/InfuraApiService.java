package com.ovijive.service;

import com.ovijive.entities.TickerResponse;
import com.ovijive.entities.TickerResponseFull;
import com.ovijive.entities.Tickers;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static com.ovijive.service.LiveTickerService.tickerService;
import static com.ovijive.service.LiveTickerService.tickerServiceFull;

@Service
public class InfuraApiService {


    public InfuraApiService() {
    }

    //pub-private :
    public static Model pingInfura(Model model) throws Exception {
        return updateInf(model);
    }

    private static Model updateInf(Model model) throws Exception {

        //short ticker:
        TickerResponse tickerResponseEthUsd = tickerService("ethusd");
        TickerResponse tickerResponseEthBtc = tickerService("ethbtc");


        //full ticker:
        TickerResponseFull tickerResponseFullEthUsd = tickerServiceFull("ethusd");
        TickerResponseFull tickerResponseFullEthBtc = tickerServiceFull("ethbtc");

        String hiVolExchEthUsd = tickerResponseEthUsd.getExchange();
        Double askEthUsd = tickerResponseEthUsd.getAsk();
        Double bidEthUsd = tickerResponseEthUsd.getBid();

        String hiVolExchEthBtc = tickerResponseEthBtc.getExchange();
        Double askEthBtc = tickerResponseEthBtc.getAsk();
        Double bidEthBtc = tickerResponseEthBtc.getBid();

        String baseFullEthUsd = tickerResponseFullEthUsd.getBase();
        String quoteFullEthUsd = tickerResponseFullEthUsd.getQuote();
        Tickers[] tickersFullEthUsd = tickerResponseFullEthUsd.getTickers();

        String baseFullEthBtc = tickerResponseFullEthBtc.getBase();
        String quoteFullEthBtc = tickerResponseFullEthBtc.getQuote();
        Tickers[] tickersFullEthBtc = tickerResponseFullEthBtc.getTickers();

        for (Tickers ticker : tickersFullEthUsd) {
            System.out.println(ticker);
        }

        Web3jService.pingWeb3j(model);

        //debug:
        System.out.println("hiVolExchEthUsd: " + hiVolExchEthUsd);
        System.out.println("askEthUsd: " + askEthUsd);
        System.out.println("askEthUsd: " + askEthUsd);

        System.out.println("hiVolExchEthBtc: " + hiVolExchEthBtc);
        System.out.println("askEthBtc: " + askEthBtc);
        System.out.println("askEthBtc: " + askEthBtc);

        System.out.println("baseFullEthUsd: " + baseFullEthUsd);
        System.out.println("quoteFullEthUsd: " + quoteFullEthUsd);
        for (Tickers ticker : tickersFullEthUsd) {
            System.out.println(ticker);
        }
        System.out.println("baseFullEthBtc: " + baseFullEthBtc);
        System.out.println("quoteFullEthBtc: " + quoteFullEthBtc);
        for (Tickers ticker : tickersFullEthBtc) {
            System.out.println(ticker);
        }

        //create object/methods for above and Get properties for below?

        //MVC:
        model.addAttribute("hiVolExchEthUsd", hiVolExchEthUsd);
        model.addAttribute("askEthUsd", askEthUsd);
        model.addAttribute("bidEthUsd", bidEthUsd);

        model.addAttribute("hiVolExchEthBtc", hiVolExchEthBtc);
        model.addAttribute("askEthBtc", askEthBtc);
        model.addAttribute("bidEthBtc", bidEthBtc);

        //rewrites, no good:
//        for (Tickers ticker : tickersFullEthUsd) {
//            model.addAttribute("tickersFullEthUsd", ticker);
//        }

        // works with Thymeleaf th:each
//        for (Tickers ticker2 : tickersFullEthBtc) {
        model.addAttribute("tickersFullEthUsd", tickersFullEthUsd);
        model.addAttribute("tickersFullEthBtc", tickersFullEthBtc);


//        model.addAttribute("tickersFullEthBtc", Arrays.toString(tickersFullEthBtc));

        //JSON error:
//        model.addAttribute("wallet1Date", wallet1().getDate());

//        System.out.println(wallet1().toString());

//        model.addAttribute("wallet2", wallet2());

//        model.addAttribute("timeStamp", "4:20");

        System.out.println("model" + model.toString());

        return model;
    }
}