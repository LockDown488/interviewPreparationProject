package ru.kopanev.spring.feature_10.task_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        int[] workers = new int[]{0, 1, 2, 3, 4, 5, 6, 7};

        for (int workerId : workers) {
            executor.submit(() -> workOnMachine(workerId));
        }

        executor.shutdown();
    }

    private static void workOnMachine(int workerId) {
        try {
            System.out.println("worker " + workerId + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + workerId + " release production machine");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
