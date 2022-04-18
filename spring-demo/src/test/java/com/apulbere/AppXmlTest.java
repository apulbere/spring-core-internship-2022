package com.apulbere;

import com.apulbere.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AppXmlTest {

    private final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-configs.xml");

    @Test
    void shouldGetMessage() {
        MessageService messageService = applicationContext.getBean(MessageService.class);
        assertThat(messageService)
                .isNotNull()
                .extracting(MessageService::message)
                .isEqualTo("xml based");
    }
}
