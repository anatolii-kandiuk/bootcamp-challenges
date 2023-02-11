package org.bootcamp;

import org.bootcamp.Hangman.Hangman;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Hangman!");

        Hangman hangman = new Hangman();

        hangman.playHangman();

    }
}