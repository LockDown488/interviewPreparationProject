package ru.kopanev.spring.feature_9.task2;

public record Post(String text, Integer likesCount) {
    @Override
    public String toString() {
        return "Пост: " + text + ", Лайков: " + likesCount;
    }
}
