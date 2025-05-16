package ru.kopanev.spring.feature_11.task1.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.text.SimpleDateFormat;
import java.util.Locale;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public SimpleDateFormat isoDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @Bean
    @Scope("prototype")
    public SimpleDateFormat localizedDateFormat(Locale locale) {
        if (locale.equals(Locale.forLanguageTag("ru"))) {
            return new SimpleDateFormat("EEEE, d MMMM, yyyy", locale);
        } else {
            return new SimpleDateFormat("EEEE, MMMM d, yyyy", locale);
        }
    }

    @Bean
    public Locale locale() {
        return Locale.ENGLISH;
    }
}
