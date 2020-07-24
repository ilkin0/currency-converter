package com.ilkin.currencyconverter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private long id;

    @Column(name = "NAME")
    @Length(max = 50, message = "{currency.name.length}")
    @NotEmpty(message = "{currency.name.notempty}")
    private String name;

    @Column(name = "CODE")
    @Length(max = 3, message = "{currency.code.length}")
    @NotEmpty(message = "{currency.code.notempty}")
    private String code;

    @Column(name = "NOMINAL")
    @Length(max = 10, message = "{currency.nominal.length}")
    @NotEmpty(message = "{currency.nominal.notempty}")
    private String nominal;

    @Column(name = "VALUE")
    @NotNull(message = "{currency.value.notnull}")
    @Digits(message = "{currency.value.digits}", integer = 1, fraction = 10)
    private BigDecimal valueForAZN;

}
