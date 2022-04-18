package com.apulbere;

import com.apulbere.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

public class AppAnnotationTest {

    private final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

    @Configuration
    static class Config {

        @Bean
        MessageService messageService() {
            return new MessageService("annotation based");
        }
    }

    @Test
    void shouldGetMessage() {
        MessageService messageService = applicationContext.getBean(MessageService.class);
        assertThat(messageService)
                .isNotNull()
                .extracting(MessageService::message)
                .isEqualTo("annotation based");
    }
}
