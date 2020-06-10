package com.ilkin.currencyconverter.repo;

public class SqlQuery {

    public static final String RESET_CURRENCY_TABLE = "truncate currency_list restart identity";

    public static final String INSERT_CURRENCY_INTO_DB = "insert into currency_list(insert_date, code, nominal, name, value) " +
            "VALUES (current_timestamp, :code, :nominal;, :name, value)";
}
