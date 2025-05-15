package ru.kopanev.spring.feature_9.task3;

import jakarta.persistence.EntityNotFoundException;

import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    private static int sumAgesOfName(List<Client> clients, String name) {
        return clients.stream()
                .filter(client -> client.getName().equals(name))
                .map(Client::getAge)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static Set<String> getClientsNameInOrder(List<Client> clients) {
        return clients.stream()
                .map(Client::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static boolean hasClientOlderThan(List<Client> clients, int age) {
        return clients.stream()
                .map(Client::getAge)
                .filter(client -> client > age)
                .findAny().isPresent();
    }

    private static Map<Long, String> getIdNameEntry(List<Client> clients) {
        return clients.stream()
                .collect(Collectors.toMap(
                        Client::getId,
                        Client::getName,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ));
    }

    private static Map<Integer, List<Client>> getAgeClientsEntry(List<Client> clients) {
        return clients.stream()
                .collect(Collectors.groupingBy(
                        Client::getAge,
                        LinkedHashMap::new,
                        Collectors.mapping(client -> client, Collectors.toList())
                ));
    }

    private static String getClientPhones(List<Client> clients) {
        return clients.stream()
                .flatMap(client -> client.getPhones().stream()
                        .map(Phone::number))
                .collect(Collectors.joining(", "));
    }

    private static Client getOldestClientWithStationaryPhone(List<Client> clients) {
        return clients.stream()
                .filter(client -> client.getPhones().stream()
                        .anyMatch(phone -> phone.type().equals("Стационарный")))
                .max((c1, c2) -> Integer.compare(c1.getAge(), c2.getAge()))
                .orElseThrow(() -> new EntityNotFoundException("Нет клиентов со стационарным телефоном"));
    }
}
