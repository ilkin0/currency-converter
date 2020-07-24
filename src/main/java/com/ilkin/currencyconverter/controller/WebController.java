package com.ilkin.currencyconverter.controller;

import com.ilkin.currencyconverter.entity.Currency;
import com.ilkin.currencyconverter.exception.generic.EntityNotFoundException;
import com.ilkin.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WebController {

    @Autowired
    CurrencyService currencyService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Currency> findAll() throws EntityNotFoundException {
        return currencyService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{code}")
    public Currency findByCode(@PathVariable("code") String code) throws EntityNotFoundException {
        return currencyService.findByCode(code);
    }

}
