package org.example.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractGame implements Game {
    Integer sizeWord;
    String word;
    Integer maxTry;

    static int countTry;
    GameStatus gameStatus = GameStatus.INIT;

    private String generateWord() throws IOException {
        List<String> charList = generateCharList();
        StringBuilder res = new StringBuilder();
        if (sizeWord == 0) {
            for (String s : charList) {
                res.append(s);
            }
        } else {
            for (int i = 0; i < sizeWord; i++) {
                res.append(charList.get(i));
            }
        }
        return res.toString();
    }

    @Override
    public void start(Integer sizeWord, Integer maxTry) throws IOException {
        this.maxTry = maxTry;
        this.sizeWord = sizeWord;
        word = generateWord();
        this.gameStatus = GameStatus.START;
    }

    public void start(Integer maxTry) throws IOException {
        this.maxTry = maxTry;
        this.sizeWord = 0;
        word = generateWord();
        this.gameStatus = GameStatus.START;
    }

    @Override
    public Answer inputAnswer(String value) {
        int bull = 0;
        int cow = 0;
        int wincount = 0;
        for (int i = 0; i < value.length(); i++) {
            if (word.contains(Character.toString(value.charAt(i)))) {
                cow++;
            }
            if (word.charAt(i) == value.charAt(i)) {
                bull++;
                wincount++;
            }
        }
        countTry++;
        Answer answer = new Answer(cow, bull, value);
        if (wincount == value.length()) {
            gameStatus = GameStatus.WIN;
        } else {
            if (countTry >= maxTry) {
                gameStatus = GameStatus.LOSE;
            } else {
                gameStatus = GameStatus.START;
            }
        }
        return answer;
    }

    abstract List<String> generateCharList() throws IOException;

    public String getWord() {
        return word;
    }
}

