package ru.kopanev.spring.feature_2;

public class Cat implements Moveable {

    private double runLimitation = 1000.0;
    private double jumpLimitation = 2.5;

    @Override
    public boolean run(double length) {
        if (runLimitation >= length) {
            System.out.println("Кот успешно пробежал препятствие");
            return true;
        } else {
            System.out.println("Кот не смог пробежать");
            return false;
        }
    }

    @Override
    public boolean jump(double height) {
        if (jumpLimitation >= height) {
            System.out.println("Кот успешно перепрыгнул препятствие");
            return true;
        } else {
            System.out.println("Кот не смог перепрыгнуть препятствие");
            return false;
        }
    }
}
