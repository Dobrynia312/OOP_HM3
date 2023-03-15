package org.example.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RusWords extends AbstractGame{



    public RusWords() throws IOException {
    }

    @Override
    List<String> generateCharList() throws IOException {
        Random r = new Random();
        String str = new String(
                Files.readAllBytes(Path.of("D:\\GB\\OOP\\HM3\\src\\main\\java\\org\\example\\game\\russian_words.txt")));
        int lineNumber = r.nextInt(67775);
        String line = "";
        try {
            line = str.split("\n")[lineNumber];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Такой строки нет в файле");
        }
        List<String> res = new ArrayList<>();
        res.add(line);
        return res;
    }

    public String getWord() {
        return this.word;
    }
}
