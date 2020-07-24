package com.ilkin.currencyconverter.scheduler;

import com.ilkin.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConverterScheduler {

    @Autowired
    private CurrencyService currencyService;


    @Scheduled(cron = "0 0 14 * * *")
    public void parseCurrencies() {
//        Todo reset table before pare XML
//        Todo parse new XML file
//        Todo insert parsed XML to DB
    }
}
