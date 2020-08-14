package com.ilkin.currencyconverter.controller;

import com.ilkin.currencyconverter.entity.Currency;
import com.ilkin.currencyconverter.exception.generic.EntityNotFoundException;
import com.ilkin.currencyconverter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ilkin.currencyconverter.util.Constant.API_URL;


@RestController
@RequestMapping(API_URL)
@RequiredArgsConstructor
public class WebController {

    private final CurrencyService currencyService;

    @GetMapping
    public List<Currency> findAll() throws EntityNotFoundException {
        return currencyService.findAll();
    }

    @GetMapping("/{code}")
    public Currency findByCode(@PathVariable("code") String code) throws EntityNotFoundException {
        return currencyService.findByCode(code);
    }

}
