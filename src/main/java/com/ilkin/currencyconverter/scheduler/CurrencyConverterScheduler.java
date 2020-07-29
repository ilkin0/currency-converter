package com.ilkin.currencyconverter.scheduler;

import com.ilkin.currencyconverter.entity.Currency;
import com.ilkin.currencyconverter.exception.generic.EntityNotFoundException;
import com.ilkin.currencyconverter.repo.CurrencyRepo;
import com.ilkin.currencyconverter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.ilkin.currencyconverter.util.CurrencyUtil.xmlParser;

@Component
@RequiredArgsConstructor
public class CurrencyConverterScheduler {

    private final CurrencyRepo currencyRepo;
    private final CurrencyService currencyService;

//    @Scheduled(cron = "0 0 14 * * *")
    @Scheduled(fixedRate = 3600000)
    public void parseCurrencies() throws EntityNotFoundException {

//        reset table before parse XML
        currencyRepo.truncateTable();

//         parse new XML file
        List<Currency> currencyList = xmlParser();

//         insert parsed XML to DB
        currencyService.save(currencyList);
    }
}
