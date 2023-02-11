package org.bootcamp.Hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public void playHangman() {
        Data data = new Data();

        Scanner scan = new Scanner(System.in);

        String word = data.getRandomWord();

        int misses = 0;

        char[] placeholders = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            placeholders[i] = '*';
        }

        char[] missedGuesses = new char[6];

        while (misses < 6) {
            System.out.println(data.getGallows(misses));

            System.out.print("Word:   ");
            printPlaceholders(placeholders);
            System.out.println("\n\n");

            System.out.print("Misses:   ");
            printMissedGuesses(missedGuesses);
            System.out.println("\n\n");

            System.out.print("Guess >>   ");
            char guess = scan.nextLine().charAt(0);

            System.out.print("\n");

            if (checkGuess(word, guess)) {
                updatePlaceholders(word, placeholders, guess);
            } else {
                missedGuesses[misses] = guess;
                misses++;
            }

            if (Arrays.equals(placeholders, word.toCharArray())) {

                System.out.print(data.getGallows(misses));
                System.out.print("\nWord:   ");
                printPlaceholders(placeholders);
                System.out.println("\nYOU WIN!");

                break;
            }
        }

        if (misses == 6) {
            System.out.print(data.getGallows(6));
            System.out.println("\nRIP!");
            System.out.println("\nThe word was: '" + word + "'");
        }
        scan.close();

    }


    private void printPlaceholders(char[] placeholders) {
        for (int i = 0; i < placeholders.length; i++) {
            System.out.print(" " + placeholders[i]);
        }
        System.out.print("\n");
    }

    private void printMissedGuesses(char[] misses) {
        for (int i = 0; i < misses.length; i++) {
            System.out.print(misses[i]);
        }
    }

    private void updatePlaceholders(String word, char[] placeholders, char guess) {

        for (int j = 0; j < word.length(); j++) {

            if (word.charAt(j) == guess) {
                placeholders[j] = guess;
            }
        }
    }

    private boolean checkGuess(String word, char guess) {

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                return true;
            }
        }
        return false;

    }
}
