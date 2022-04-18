package com.apulbere;

import com.apulbere.service.BubbleSortAlgo;
import com.apulbere.service.QuickSortAlgo;
import com.apulbere.service.SortAlgo;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

public class EnvDependentBeansTest {

    @Configuration
    static class Config {

        /**
         * -Dspring.profiles.active=dev
         */
        @Bean
        @Profile("dev")
        @Primary
        SortAlgo bubbleSort() {
            return new BubbleSortAlgo();
        }

        @Bean
        @Profile("prod")
        SortAlgo quickSort() {
            return new QuickSortAlgo();
        }
    }

    private final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

    @Test
    void shouldSort() {
        var sortAlgo = applicationContext.getBean(SortAlgo.class);
        var values = List.of("ABC", "XYZ");

        sortAlgo.sort(values);
    }

}
