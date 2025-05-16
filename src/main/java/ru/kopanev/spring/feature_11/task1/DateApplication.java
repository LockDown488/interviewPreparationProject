package ru.kopanev.spring.feature_11.task1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kopanev.spring.feature_11.task1.configuration.AppConfig;
import ru.kopanev.spring.feature_11.task1.service.DateService;

import java.util.Scanner;

public class DateApplication {
    public static void main(String[] args) {
        String profile = args.length > 0 ? args[0] : "en";

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles(profile);
        context.register(AppConfig.class);
        context.refresh();

        DateService dateService = context.getBean(DateService.class);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current locale: " + dateService.getCurrentLocale());
        System.out.println("Available commands: today, today-iso, exit");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(command)) {
                break;
            } else if ("today".equalsIgnoreCase(command)) {
                System.out.println(dateService.getToday());
            } else if ("today-iso".equalsIgnoreCase(command)) {
                System.out.println(dateService.getTodayIso());
            } else {
                System.out.println("Unknown command");
            }
        }

        context.close();
        scanner.close();
    }
}
