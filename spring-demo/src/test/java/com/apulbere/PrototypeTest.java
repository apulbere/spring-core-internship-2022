package com.apulbere;

import static org.assertj.core.api.Assertions.assertThat;

import com.apulbere.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class PrototypeTest {

    @Configuration
    @ComponentScan("com.apulbere")
    static class Config {
    }

    private final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

    @Test
    void shouldReturnEachTimeDifferentPrototype() {
        var currencyService = applicationContext.getBean(CurrencyService.class);

        assertThat(currencyService.usdExchangeRate()).isNotNull();
        assertThat(currencyService.usdExchangeRate() == currencyService.usdExchangeRate()).isFalse();
    }


}
