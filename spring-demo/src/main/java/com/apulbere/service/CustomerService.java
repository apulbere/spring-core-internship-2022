package com.apulbere.service;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;
import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

import com.apulbere.repository.CustomerRepository;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Lazy
@Service
@Scope(scopeName = SCOPE_SINGLETON, proxyMode = TARGET_CLASS)
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService() {
        log.info("constructor");
        log.info("constructor customerRepository {}", customerRepository);
    }

    @PostConstruct
    private void postConstruct() {
        log.info("post construct");
        log.info("post construct customerRepository {}", customerRepository);
    }

    private void init() {
        log.info("init");
        log.info("init customerRepository {}", customerRepository);
    }

    @PreDestroy
    private void preDestroy() {
        log.info("pre destroy");
    }

    private void destroy() {
        log.info("destroy");
    }

    public UUID createCustomer() {
        return UUID.randomUUID();
    }
}
