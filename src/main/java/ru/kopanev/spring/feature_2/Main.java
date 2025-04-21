package ru.kopanev.spring.feature_2;

import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Moveable[] participants = new Moveable[3];

        participants[0] = new Human();
        participants[1] = new Cat();
        participants[2] = new Robot();

        Obstacle[] obstacles = new Obstacle[5];

        for (int i = 0; i < obstacles.length; i++) {
            if (i % 2 == 0) {
                obstacles[i] = new Treadmill(generateRandomLength());
            } else {
                obstacles[i] = new Wall(generateRandomHeight());
            }
        }

        for (Moveable participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    break;
                }
            }
        }
    }

    private static double generateRandomLength() {
        return Math.round(RANDOM.nextDouble() * 2000 * 10) / 10.0;
    }

    private static double generateRandomHeight() {
        return Math.round(RANDOM.nextDouble() * 5 * 10) / 10.0;
    }
}
