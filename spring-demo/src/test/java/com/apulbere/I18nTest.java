package com.apulbere;

import com.apulbere.service.GreetingsService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class I18nTest {

    @Configuration
    static class Config {

        @Bean
        MessageSource messageSource() {
            var resourceBundleMessageSource = new ResourceBundleMessageSource();
            resourceBundleMessageSource.setBasename("messages");
            return resourceBundleMessageSource;
        }

        @Bean
        GreetingsService greetingsService(MessageSource messageSource) {
            return new GreetingsService(messageSource);
        }
    }

    private final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

    @Test
    void shouldSayHiIndifferentLangs() {
        var service = applicationContext.getBean(GreetingsService.class);

        assertThat(service.sayHi()).isEqualTo("Good morning");

        Locale.setDefault(Locale.FRANCE);

        assertThat(service.sayHi()).isEqualTo("Bonjour");
    }
}
