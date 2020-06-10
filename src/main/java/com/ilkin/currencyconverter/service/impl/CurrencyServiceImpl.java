package com.ilkin.currencyconverter.service.impl;

import com.ilkin.currencyconverter.model.Currency;
import com.ilkin.currencyconverter.repo.CurrencyRepo;
import com.ilkin.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepo currencyRepo;

    @Override
    public List<Currency> parseXML() {

        List<Currency> currencyList = new ArrayList<>();
        try {

            LocalDate now = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy");

            String url = "https://www.cbar.az/currencies/" + formatter.format(now) + ".xml";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(url));

            NodeList valute = document.getElementsByTagName("Valute");

            for (int i = 0; i < valute.getLength(); i++) {
                Node node = valute.item(i);
                Element element = (Element) node;

                Currency currency = new Currency();

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    String name = element.getElementsByTagName("Name").item(0).getTextContent();
                    currency.name(name);

                    String code = element.getAttribute("Code");
                    currency.code(code);

                    String nominal = element.getElementsByTagName("Nominal").item(0).getTextContent();
                    currency.nominal(nominal);

                    String value = element.getElementsByTagName("Value").item(0).getTextContent();
                    currency.valueForAZN(new BigDecimal(value));

                    currencyList.add(currency);

                }

            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return currencyList;
    }

    @Override
    public void resetTable() {
        currencyRepo.resetTable();
    }

    @Override
    public void insertCurrencyListIntoDB( List<Currency> currencyList) {
        for (Currency currency : currencyList) {
            currencyRepo.insertCurrency(currency);
        }
    }
}
