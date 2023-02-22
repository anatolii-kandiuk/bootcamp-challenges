package org.bootcamp.Pokerito;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CardsReader {

    private static final String filename = "/home/anatolii/Education/Udemy/Java/JavaCore/Bootcamp/bootcamp-challenges/src/main/java/org/bootcamp/Pokerito/cards.txt";

    public static ArrayList<String> cardsRead() {

        ArrayList<String> result = new ArrayList<>();

        try (FileReader f = new FileReader(filename)) {

            StringBuffer sb = new StringBuffer();

            while (f.ready()) {
                char c = (char) f.read();

                if (c == '#') {
                    result.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                result.add(sb.toString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

}
