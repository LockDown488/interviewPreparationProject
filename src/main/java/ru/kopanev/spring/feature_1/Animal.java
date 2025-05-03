package ru.kopanev.spring.feature_1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Animal {

    private String name;
    private int runLimitation;
    private int swimLimitation;

    public void run(int length) {
        if (length > runLimitation) {
            System.out.println(String.format(
                    "%s не может пробежать дистанцию больше, чем %d метров!", name, runLimitation
            ));
        } else {
            System.out.println(String.format("%s пробежал %d метров", name, length));
        }
    }

    public void swim(int length) {
        if (swimLimitation == 0) {
            System.out.println(String.format("%s не умеет плавать", name));
        } else if (length > swimLimitation) {
            System.out.println(String.format(
                    "%s не может проплыть дистанцию больше, чем %d метров!", name, swimLimitation
            ));
        } else {
            System.out.println(String.format("%s проплыл %d метров", name, length));
        }
    }
}
