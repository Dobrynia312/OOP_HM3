package org.example.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunGame {
    public static void runGame() throws IOException {
        System.out.println("""
                Начнём игру
                чтобы выйти введите Stop this,
                чтобы выбрать игру введите:
                1 - цифры.
                2 - английские слова.
                3 - русские слова.""");
        Scanner in = new Scanner(System.in);
        int num;
        String inUs = in.next();
        try {
            num = Integer.parseInt(inUs);
        } catch (NumberFormatException nfe) {
            num = Integer.MIN_VALUE;
        }
        Game game = null;
        switch (num) {
            case 1 -> {
                game = new NumberGame();
                game.start(3, 15);
                System.out.println(game.getWord());
            }
            case 2 -> {
                game = new EngWords();
                game.start(15);
                System.out.println(game.getWord());
            }
            case 3 -> {
                game = new RusWords();
                game.start(15);
                System.out.println(game.getWord());
            }
            default -> System.out.println("такой игры еще не существует");
        }
        ArrayList<String> userAnswers = new ArrayList<>();
        while (game != null && game.getGameStatus().equals(GameStatus.START)) {
            System.out.println("ваш ход");
            String answer = in.next();
            userAnswers.add("UserInput "+answer);
            Answer answerGame = game.inputAnswer(answer);
            System.out.printf("Найдено %d коров и %d быков\n", answerGame.getCows(), answerGame.getBulls());
        }
        System.out.println(game.getGameStatus());
        System.out.println("Вывести попытки? Y/N");
        String viewAnswer = in.next();
        if (viewAnswer.equals("Y")){
            for (String item:userAnswers
                 ) {
                System.out.println(item);
            }
    }
}}

