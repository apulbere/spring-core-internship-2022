package com.apulbere.service;

import com.apulbere.model.AccountCreated;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class AccountService {

    private final ApplicationEventPublisher publisher;

    public void create() {
        var newAccountId = UUID.randomUUID();
        log.info("creating account {}", newAccountId);
        /* account creation logic */
        log.info("account {} was created", newAccountId);

        publisher.publishEvent(new AccountCreated(newAccountId));
    }
}
