package com.ilkin.currencyconverter.repo;

import com.ilkin.currencyconverter.model.Currency;

public interface CurrencyRepo {
    void resetTable();

    void insertCurrency(Currency currency);
}
