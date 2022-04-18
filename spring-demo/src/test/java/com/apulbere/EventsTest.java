package com.apulbere;

import com.apulbere.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class EventsTest {

    @Configuration
    @ComponentScan("com.apulbere")
    static class Config {

    }

    private final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

    @Test
    void shouldPublishEvents() {
        var accountService = applicationContext.getBean(AccountService.class);
        accountService.create();
    }
}
