package com.apulbere.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSortAlgo implements SortAlgo {

    @Override
    public void sort(List<String> values) {
        log.info("quick sort {}", values);
    }
}
