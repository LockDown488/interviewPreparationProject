package ru.kopanev.spring.feature_2;

public class Robot implements Moveable {

    private double runLimitation = 1500.0;
    private double jumpLimitation = 3.5;

    @Override
    public boolean run(double length) {
        if (runLimitation >= length) {
            System.out.println("Робот успешно пробежал препятствие");
            return true;
        } else {
            System.out.println("Робот не смог пробежать");
        }

        return false;
    }

    @Override
    public boolean jump(double height) {
        if (jumpLimitation >= height) {
            System.out.println("Робот успешно перепрыгнул препятствие");
            return true;
        } else {
            System.out.println("Робот не смог перепрыгнуть препятствие");
        }

        return false;
    }
}
