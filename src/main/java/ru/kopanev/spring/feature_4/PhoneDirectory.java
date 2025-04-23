package ru.kopanev.spring.feature_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneDirectory {

    private final Map<String, Set<String>> phoneNumbers = new HashMap<>();

    public void addPhoneNumber(String surname, String phoneNumber) {
        Set<String> numbers = phoneNumbers.computeIfAbsent(surname, k -> new HashSet<>());
        numbers.add(phoneNumber);
    }

    public Set<String> getPhoneNumber(String surname) {
        return phoneNumbers.get(surname);
    }
}
