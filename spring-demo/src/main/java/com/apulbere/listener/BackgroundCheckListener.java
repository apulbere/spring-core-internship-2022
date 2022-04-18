package com.apulbere.listener;

import com.apulbere.model.AccountCreated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BackgroundCheckListener {

    @EventListener
    public void listen(AccountCreated accountCreated) {
        log.info("starting background check for account {}", accountCreated);
    }
}
