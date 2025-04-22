package ru.kopanev.spring.feature_2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Treadmill extends Obstacle {

    private double length;

    @Override
    boolean overcome(Moveable participant) {
        return participant.run(length);
    }
}
