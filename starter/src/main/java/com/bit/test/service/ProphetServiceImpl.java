package com.bit.test.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProphetServiceImpl implements ProphetService {

    @Override
    public Boolean willSurvice(String name) {
        return !name.contains("Stark")
                && ThreadLocalRandom.current().nextBoolean();
    }
}
