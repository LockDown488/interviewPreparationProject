package ru.kopanev.spring.feature_7.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorServiceConfig {

    @Value("${spring.data.thread.thread-size}")
    private int threadPoolSize;

    @Bean
    public ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(threadPoolSize);
    }
}
