package com.ilkin.currencyconverter.controller;

import com.ilkin.currencyconverter.model.Currency;
import com.ilkin.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    CurrencyService currencyService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        List<Currency> currencyList = currencyService.parseXML();
//        for (Currency currency : currencyList){
//            System.out.println(currency);
//        }
        return "web/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/converter")
    public String converter() {
        return "web/converter";
    }

}
