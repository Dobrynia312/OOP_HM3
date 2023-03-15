package org.example.game;

import java.io.IOException;

public interface Game {
    void start( Integer sizeWord, Integer maxTry) throws IOException;
    void start( Integer maxTry) throws IOException;
    Answer inputAnswer(String value);
    GameStatus getGameStatus();

    String getWord();
}
