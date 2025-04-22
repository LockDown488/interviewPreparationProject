package ru.kopanev.spring.feature_2;

public class Human implements Moveable {

    private double runLimitation = 750.0;
    private double jumpLimitation = 1.5;

    @Override
    public boolean run(double length) {
        if (runLimitation >= length) {
            System.out.println("Человек успешно пробежал препятствие");
            return true;
        } else {
            System.out.println("Человек не смог пробежать");
            return false;
        }
    }

    @Override
    public boolean jump(double height) {
        if (jumpLimitation >= height) {
            System.out.println("Человек успешно перепрыгнул препятствие");
            return true;
        } else {
            System.out.println("Человек не смог перепрыгнуть препятствие");
            return false;
        }
    }
}
