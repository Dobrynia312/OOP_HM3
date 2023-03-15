package org.example.game;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class EngWords extends AbstractGame{



    public EngWords() throws IOException {
    }

    @Override
    List<String> generateCharList() throws IOException {
        Random r = new Random();
        String str = new String(
                Files.readAllBytes(Path.of("D:\\GB\\OOP\\HM3\\src\\main\\java\\org\\example\\game\\words.txt")));
        int lineNumber = r.nextInt(3848);
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
        return super.getWord();
    }
}
