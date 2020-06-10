package com.ilkin.currencyconverter.repo.impl;

import com.ilkin.currencyconverter.model.Currency;
import com.ilkin.currencyconverter.repo.CurrencyRepo;
import com.ilkin.currencyconverter.repo.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyRepoImpl implements CurrencyRepo {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void resetTable() {
        jdbcTemplate.update(SqlQuery.RESET_CURRENCY_TABLE);
    }

    @Override
    public void insertCurrency(Currency currency) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("code", currency.code());
        mapSqlParameterSource.addValue("name", currency.name());
        mapSqlParameterSource.addValue("nominal", currency.nominal());
        mapSqlParameterSource.addValue("value", currency.valueForAZN());

        namedParameterJdbcTemplate.update(SqlQuery.INSERT_CURRENCY_INTO_DB, mapSqlParameterSource);
    }
}
