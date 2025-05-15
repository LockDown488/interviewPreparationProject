package ru.kopanev.spring.feature_10.task_1;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class Leg implements Runnable {

    private static boolean isLeftTurn = true;
    private final String name;

    @Override
    public void run() {
        while (true) {
            synchronized (Leg.class) {
                if (name.equals("left") && isLeftTurn) {
                    System.out.println(name);
                    isLeftTurn = false;
                } else if (name.equals("right") && !isLeftTurn) {
                    System.out.println(name);
                    isLeftTurn = true;
                }
            }

        }
    }

    public static void main(String[] args) {
        CompletableFuture.allOf(
                CompletableFuture.runAsync(new Leg("left")),
                CompletableFuture.runAsync(new Leg("right"))
        ).join();
    }
}
