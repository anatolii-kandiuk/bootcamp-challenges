package org.bootcamp.Pokerito;

import java.util.Scanner;

public class Pokerito {
    public static void runPokerito() {
        System.out.println(
                "Let's play Pokerito. Type anything when you're ready.\n" +
                "\n" +
                "It's like Poker, but a lot simpler.\n" +
                "\n" +
                "- There are two players, you and the computer.\n" +
                "\n" +
                "- The dealer will give each player one card.\n" +
                "\n" +
                "- Then, the dealer will draw five cards (the river)\n" +
                "\n" +
                "- The player with the most river matches wins!\n" +
                "\n" +
                "- If the matches are equal, everyone's a winner!\n" +
                "\n" +
                "- Ready? Type anything if you are."
        );
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        String yourCard = Data.randomCard();
        String computerCard = Data.randomCard();
        String dealerCard = "";

        System.out.println("Your card:\n" + yourCard);
        scan.nextLine();

        System.out.println("Computer card:\n" + computerCard);
        scan.nextLine();

        int computerCounter = 0;
        int yourCounter = 0;

        for(int i = 1; i <= 5; i++) {
            System.out.println("Card " + i);

            dealerCard = Data.randomCard();

            System.out.println(dealerCard);

            scan.nextLine();

            if(yourCard.equals(dealerCard)) {
                yourCounter++;
            }
            if (computerCard.equals(dealerCard)) {
                computerCounter++;
            }
        }

        System.out.println("\nComputer numbers of matches: " + computerCounter);
        System.out.println("Your numbers of matches: " + yourCounter);

        if(yourCounter > computerCounter) {
            System.out.println("YOU WIN!!!");
        } else if (yourCounter < computerCounter) {
            System.out.println("COMPUTER WIN!!!");
        } else {
            System.out.println("NICE");
        }

    }
}
