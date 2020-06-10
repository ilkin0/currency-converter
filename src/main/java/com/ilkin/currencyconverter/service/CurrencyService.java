package com.ilkin.currencyconverter.service;

import com.ilkin.currencyconverter.model.Currency;

import java.util.List;

public interface CurrencyService {

    List<Currency> parseXML();
    void resetTable();
    void insertCurrencyListIntoDB(List<Currency> currencyList);

}
