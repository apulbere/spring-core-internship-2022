package com.apulbere.service;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Scope(SCOPE_PROTOTYPE)
public record UsdExchangeRate() {

    public UsdExchangeRate {
        log.info("instance created");
    }
}
