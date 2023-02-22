package org.bootcamp.Pokerito;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static final List<String> cards = CardsReader.cardsRead();

    /**
     * Function name -- randomCard
     * @return (String)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card that matches the random number.
     */
    public static String randomCard() {

        int randomNumber = (int) (Math.random() * 13 + 1);

        return cards.get(randomNumber);
    }

}
