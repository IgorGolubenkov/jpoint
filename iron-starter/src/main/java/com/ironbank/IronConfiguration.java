package com.ironbank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IronConfiguration {

    @Bean
    public IronListener ironListener() {
        return new IronListener();
    }
}
