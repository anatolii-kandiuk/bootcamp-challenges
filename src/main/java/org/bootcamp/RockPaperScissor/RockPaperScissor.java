package org.bootcamp.RockPaperScissor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {

    private final List<String> listRockPaperScissor = Arrays.asList("rock", "paper", "scissors");

    public void runRockPaperScissor() {
        System.out.println(">>Let's play Rock Paper Scissors.");
        System.out.println(">>When I say 'shoot', Choose: rock, paper, or scissors.\n>> ");

        Scanner scan = new Scanner(System.in);

        String yourChoice = scan.nextLine();
        String computerChoice = this.getComputerChoice();

        String result = this.check(yourChoice, computerChoice);

        this.printResult(yourChoice, computerChoice, result);

    }

    /**
     * Function name: computerChoice - picks a randomly between rock paper and scissors
     * @return a choice (String).
     *
     * Inside the function:
     *   1. Picks a random number between 0 and 2.
     *   2. if 0: returns the choice 'rock'
     *      if 1: returns the choice 'paper'
     *      if 2: returns the choice 'scissors'
     */
    private String getComputerChoice() {
        Random rand = new Random();

        return this.listRockPaperScissor.get(rand.nextInt(listRockPaperScissor.size()));
    }

    /**
     * Function name: result - It returns the result of the game.
     *  @param yourChoice (String)
     *  @param computerChoice (String)
     *  @return result (String)
     *
     * Inside the function:
     *   1. result is "You win" if:
     *
     *       You: "rock"      Computer: "scissors"
     *       You: "paper"     Computer: "rock"
     *       You: "scissors"  Computer: "paper"
     *
     *   2. result is "You lose" if:
     *
     *       Computer: "rock"      You: "scissors"
     *       Computer: "paper"     You: "rock"
     *       Computer: "scissors"  You: "paper"
     *
     *   3. result is "It's a tie" if:
     *
     *       your choice equals computer choice.
     *
     *   4. Otherwise, print "ERROR" and exit the program.
     */

    private String check(String yourChoice, String computerChoice) {

        if(
                (yourChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (yourChoice.equals("paper") && computerChoice.equals("rock")) ||
                        (yourChoice.equals("scissors") && computerChoice.equals("paper"))){
            return "YOU WIN!";
        } else if (
                (yourChoice.equals("rock") && computerChoice.equals("paper")) ||
                        (yourChoice.equals("paper") && computerChoice.equals("scissors")) ||
                        (yourChoice.equals("scissors") && computerChoice.equals("rock"))
        ) {
            return "COMPUTER WIN";
        } else {
            return "It's a tie!";
        }
    }

    /**
     * Name: printResult - It prints everything (your choice, computer choice, result)
     * @param yourChoice (String)
     * @param computerChoice (String)
     * @param result (String)
     *
     * Inside the function:
     *  1. prints everything:
     *      – prints: You chose: (tab of space) <your choice>
     *      – prints: The computer chose: (tab of space) <computer choice>
     *      – prints: <result>
     */
    public void printResult(String yourChoice, String computerChoice, String result) {
        System.out.println("\nYou chose:\t" + yourChoice);
        System.out.println("The computer chose:\t" + computerChoice);
        System.out.println(result);
    }
}
