package ru.kopanev.spring.feature_2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Wall extends Obstacle {

    private double height;

    @Override
    boolean overcome(Moveable participant) {
        if (participant instanceof Human) {
            return ((Human) participant).jump(height);
        } else if (participant instanceof Cat) {
            return ((Cat) participant).jump(height);
        } else if (participant instanceof Robot) {
            return ((Robot) participant).jump(height);
        }
        return false;
    }
}
