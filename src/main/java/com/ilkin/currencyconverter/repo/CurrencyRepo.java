package com.ilkin.currencyconverter.repo;

import com.ilkin.currencyconverter.entity.Currency;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CurrencyRepo extends CrudRepository<Currency, Long> {

    @Query("select c from Currency c where c.code = :code")
    Optional<Currency> getCurrencyByCode(String code);

    @Query(value = "truncate CURRENCY restart identity", nativeQuery = true)
    @Modifying
//    TODO niye transactional elave etmedikde islemir?
    @Transactional
    void truncateTable();

}
