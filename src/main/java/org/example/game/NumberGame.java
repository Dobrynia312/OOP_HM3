package org.example.game;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class NumberGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> charList = new ArrayList<>();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 10; ++i) {
            charList.add(String.valueOf(random.nextInt(10)));
        }
        return charList;
    }

    @Override
    public String getWord() {
        return super.getWord();
    }
}


