package com.ilkin.currencyconverter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CURRENCY")
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
//    TODO niye @Digits problem yaradir?
//    @Digits(message = "{currency.value.digits}", integer = 1, fraction = 10)
    private BigDecimal valueForAZN;

    @CreationTimestamp
    @Column(name = "CREATED_TIME", updatable = false)
    @JsonIgnore
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "UPDATE_TIME", updatable = false)
    @JsonIgnore
    private LocalDateTime updateDateTime;

}
