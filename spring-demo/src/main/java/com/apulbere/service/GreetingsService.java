package com.apulbere.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

@AllArgsConstructor
public class GreetingsService {

    private final MessageSource messageSource;

    public String sayHi() {
        return messageSource.getMessage("msg.hello", new Object[] {}, Locale.getDefault());
    }
}
