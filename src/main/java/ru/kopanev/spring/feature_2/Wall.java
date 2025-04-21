package ru.kopanev.spring.feature_2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Wall extends Obstacle {

    private double height;

    @Override
    boolean overcome(Moveable participant) {
        return participant.jump(height);
    }
}
