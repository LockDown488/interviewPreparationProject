package ru.kopanev.spring.feature_11.task1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class DateService {

    private final SimpleDateFormat isoDateFormat;
    private final SimpleDateFormat localizedDateFormat;
    private final Locale locale;

    public String getToday() {
        return localizedDateFormat.format(new Date());
    }

    public String getTodayIso() {
        return isoDateFormat.format(new Date());
    }

    public Locale getCurrentLocale() {
        return locale;
    }
}
