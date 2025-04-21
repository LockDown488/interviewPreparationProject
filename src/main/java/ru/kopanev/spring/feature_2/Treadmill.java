package ru.kopanev.spring.feature_2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Treadmill extends Obstacle {

    private double length;

    @Override
    boolean overcome(Moveable participant) {
        if (participant instanceof Human) {
            return ((Human) participant).run(length);
        } else if (participant instanceof Cat) {
            return ((Cat) participant).run(length);
        } else if (participant instanceof Robot) {
            return ((Robot) participant).run(length);
        }
        return false;
    }
}
