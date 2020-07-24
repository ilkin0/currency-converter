package com.ilkin.currencyconverter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilkin.currencyconverter.TestConfiguration;
import com.ilkin.currencyconverter.entity.Currency;
import com.ilkin.currencyconverter.repo.CurrencyRepo;
import com.ilkin.currencyconverter.service.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;


public class WebControllerTests extends TestConfiguration {

    @Autowired
    private MockMvc mockMvc;

    private CurrencyService currencyService;

    private CurrencyRepo currencyRepo;

    private Currency requestObject;
    private String requestBody;
    private Currency responseObject;
    private String responseBody;

    private List<Currency> responseBodyObjectList;
    private String responseObjectListBody;

    public static String getJsonString(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @BeforeEach
    public void init() throws JsonProcessingException {

        requestObject = new Currency();
        requestObject.setName("Azerbaycan manati");
        requestObject.setNominal("1");
        requestObject.setCode("azn");
        requestObject.setValueForAZN(new BigDecimal(1));

        requestBody = getJsonString(requestObject);

        responseObject = new Currency();
        responseObject.setId(1);
        responseObject.setName(requestObject.getName());
        responseObject.setCode(requestObject.getCode());
        responseObject.setNominal(requestObject.getNominal());
        responseObject.setValueForAZN(requestObject.getValueForAZN());

        responseBody = getJsonString(responseObject);

        responseBodyObjectList = new ArrayList<>();
        responseBodyObjectList.add(responseObject);

        responseObjectListBody = getJsonString(responseBodyObjectList);
    }
//    Todo INtegrationt tests

}
