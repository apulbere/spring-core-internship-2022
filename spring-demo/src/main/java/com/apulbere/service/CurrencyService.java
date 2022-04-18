package com.apulbere.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyService {

    //ObjectFactory
    private final UsdExchangeRate usdExchangeRate;

//    @Lookup
    public UsdExchangeRate usdExchangeRate() {
        return usdExchangeRate;
    }
}
