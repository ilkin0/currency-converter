package com.ilkin.currencyconverter.service.impl;

import com.ilkin.currencyconverter.entity.Currency;
import com.ilkin.currencyconverter.exception.generic.EntityNotFoundException;
import com.ilkin.currencyconverter.repo.CurrencyRepo;
import com.ilkin.currencyconverter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepo currencyRepo;

    @Override
    public List<Currency> findAll() throws EntityNotFoundException {
        List<Currency> currencies = IteratorUtils.toList(currencyRepo.findAll().iterator());
        if (currencies.isEmpty()) throw new EntityNotFoundException(Currency.class);
        return currencies;
    }

    @Override
    public Currency findByCode(String code) throws EntityNotFoundException {
        return currencyRepo.getCurrencyByCode(code).orElseThrow(() -> new EntityNotFoundException(Currency.class, code));
    }

}
