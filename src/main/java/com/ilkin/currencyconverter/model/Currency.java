package com.ilkin.currencyconverter.model;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(fluent = true) @Getter
public class Currency {
    private String name;
    private String code;
    private String nominal;
    private BigDecimal valueForAZN;
}
