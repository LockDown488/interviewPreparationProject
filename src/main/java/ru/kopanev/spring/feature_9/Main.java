package ru.kopanev.spring.feature_9;

import ru.kopanev.spring.feature_9.task1.Competitor;
import ru.kopanev.spring.feature_9.task2.Post;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // задача 1
        List<String> data = Arrays.asList(
                "Ivan 5",
                "Petr 3",
                "Alex 10",
                "Petr 8",
                "Ivan 6",
                "Alex 5",
                "Ivan 1",
                "Petr 5",
                "Alex 1",
                "John 16",
                "Alice 16"
        );

        showWinner(data);

        // задача 2

        List<Post> posts = Arrays.asList(
                new Post("Первый пост о жизни.", 23),
                new Post("Как приготовить идеальный завтрак?", 45),
                new Post("Летние каникулы на море!", 67),
                new Post("Мои планы на будущее.", 8),
                new Post("Как я проводил выходные.", 54),
                new Post("Секреты продуктивной работы.", 12),
                new Post("Книги, которые стоит прочитать.", 30),
                new Post("Лучшие фильмы 2023 года.", 77),
                new Post("Будущее технологий.", 15),
                new Post("Путешествие по Европе.", 39),
                new Post("Почему стоит заниматься спортом?", 5),
                new Post("История одного дня.", 36),
                new Post("Как выбрать профессию?", 10),
                new Post("Советы по саморазвитию.", 25),
                new Post("Погода в этом месяце.", 41),
                new Post("Лучшие рецепты десертов.", 78),
                new Post("Как перейти на здоровое питание.", 20),
                new Post("Мой любимый вид искусства.", 34),
                new Post("Интересные факты о науке.", 63),
                new Post("Краткий обзор событий недели.", 9),
                new Post("Мои хобби и увлечения.", 48),
                new Post("Что почитать летом?", 11),
                new Post("Топ-5 сериалов для вечернего просмотра.", 55),
                new Post("Мои любимые места в городе.", 24),
                new Post("Как справляться со стрессом?", 3),
                new Post("Обзор новых технологий.", 60),
                new Post("Как настраивать свое время?", 22),
                new Post("Советы по путешествиям.", 44),
                new Post("Как организовать рабочее место.", 17),
                new Post("Мои самые яркие воспоминания.", 29),
                new Post("Как вести дневник?", 8),
                new Post("Идеи для креативных проектов.", 50),
                new Post("Мой любимый контент в интернете.", 16)
        );

        getTop10(posts).stream()
                .forEach(System.out::println);
    }

    public static void showWinner(List<String> competitors) {
        List<Competitor> formattedCompetitors = competitors.stream()
                .map(entry -> entry.split(" "))
                .map(parts -> new Competitor(parts[0], Integer.parseInt(parts[1])))
                .toList();

        String winnerName = formattedCompetitors.stream()
                .reduce(((competitor, competitor2) -> competitor.score() >= competitor2.score() ? competitor : competitor2))
                .map(Competitor::name)
                .orElse("Победитель не определен");

        System.out.println("Победителем становится " + winnerName);
    }

    public static List<Post> getTop10(List<Post> posts) {
        return posts.stream()
                .sorted((post1, post2) -> post2.likesCount().compareTo(post1.likesCount()))
                .limit(10)
                .toList();
    }
}
