package com.apulbere.service;

import java.util.UUID;

public class BatchService {

    private final UUID id = UUID.randomUUID();

    @Override
    public String toString() {
        return "BatchService " + id;
    }
}
