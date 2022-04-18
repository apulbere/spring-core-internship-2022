package com.apulbere;

import com.apulbere.service.BatchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@Slf4j
public class ThreadScopeTest {

    @Configuration
    @ComponentScan("com.apulbere.config")
    static class Config {

        @Bean
        @Scope("thread")
        BatchService batchService() {
            return new BatchService();
        }
    }

    private final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

    @Test
    void shouldTestThreadScope() throws Exception {
        var executorService = Executors.newFixedThreadPool(3);

        List<Callable<Object>> callables = Stream.generate(this::createRunnable)
                .limit(10)
                .map(Executors::callable)
                .toList();

        executorService.invokeAll(callables);
    }

    private Runnable createRunnable() {
        return () -> {
            BatchService batchService = applicationContext.getBean(BatchService.class);
            log.info("got bean {}", batchService);
        };
    }
}
