package com.apulbere;

import static org.assertj.core.api.Assertions.assertThat;

import com.apulbere.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Configuration
    @ComponentScan("com.apulbere")
    static class Config {

        @Bean(initMethod = "init", destroyMethod = "destroy")
        CustomerService customerService() {
            return new CustomerService();
        }
    }

    private final ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

    @Test
    void shouldInvokeBeanLifecycleHookMethods() {
        var service = applicationContext.getBean(CustomerService.class);

        assertThat(service.createCustomer()).isNotNull();

        applicationContext.close();
    }
}
