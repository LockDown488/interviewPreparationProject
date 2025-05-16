package ru.kopanev.spring.feature_11.task1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Locale;

@Configuration
@Profile("en")
public class EnglishConfig {
    @Bean
    public Locale locale() {
        return Locale.ENGLISH;
    }
}
