package com.ilkin.currencyconverter.service;

import com.ilkin.currencyconverter.entity.Currency;
import com.ilkin.currencyconverter.exception.generic.EntityNotFoundException;

import java.util.List;

public interface CurrencyService {

    List<Currency> findAll() throws EntityNotFoundException;

    Currency findByCode(String code) throws EntityNotFoundException;

    List<Currency> save(List<Currency> currencyList) throws EntityNotFoundException;
}
