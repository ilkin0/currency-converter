package com.ilkin.currencyconverter.service.impl;

import com.ilkin.currencyconverter.entity.Currency;
import com.ilkin.currencyconverter.exception.generic.EntityNotFoundException;
import com.ilkin.currencyconverter.repo.CurrencyRepo;
import com.ilkin.currencyconverter.service.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CurrencyServiceImplTests {

    private CurrencyRepo currencyRepo;
    private CurrencyService currencyService;

    private Currency passed;
    private Currency expected;
    private List<Currency> expectedList;

    @BeforeEach
    public void init() {

        currencyRepo = mock(CurrencyRepo.class);

        currencyService = new CurrencyServiceImpl(currencyRepo);

        passed = new Currency();
        passed.setName("Azerbaycan Manati");
        passed.setCode("azn");
        passed.setNominal("1");
        passed.setValueForAZN(BigDecimal.ONE);


        expected = new Currency();
        expected.setId(1);
        expected.setName(passed.getName());
        expected.setCode(passed.getCode());
        expected.setNominal(passed.getNominal());
        expected.setValueForAZN(passed.getValueForAZN());

        expectedList = new ArrayList<>();
        expectedList.add(expected);

    }

    @Test
    @DisplayName("findAll()")
    public void findAll() throws EntityNotFoundException {
        Set<Currency> currencies = new HashSet<>();
        currencies.add(expected);

        when(currencyRepo.findAll()).thenReturn(expectedList);

        List<Currency> currencyList = currencyService.findAll();
        assertEquals(expectedList, currencyList);
    }

    @Test
    @DisplayName("findByCode(code)")
    public void find_by_code_when_exist() throws EntityNotFoundException {

        when(currencyRepo.getCurrencyByCode("azn")).thenReturn(Optional.of(expected));

        Currency currency = currencyService.findByCode("azn");

        assertEquals(expected, currency);
    }

    @Test
    @DisplayName("findByCode(" + 123 + ")")
    public void find_by_code_when_not_exist() {

        when(currencyRepo.getCurrencyByCode(" ")).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () ->
                currencyService.findByCode(" "));
    }

    @Test
    @DisplayName("parseXML")
    public void parseXML(){


    }
}
