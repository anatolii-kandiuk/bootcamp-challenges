package org.bootcamp;

import org.bootcamp.BankManagement.main.RunApp;
import org.bootcamp.Blackjack.Blackjack;
import org.bootcamp.Hangman.Hangman;
import org.bootcamp.Pokerito.Pokerito;
import org.bootcamp.RockPaperScissor.RockPaperScissor;
import org.bootcamp.StockTrading.RunTrading;
import org.bootcamp.TicTacToe.TicTacToe;
import org.bootcamp.Workbook11.Position;
import org.bootcamp.Workbook9.Game;
import org.bootcamp.Workbook9.Team;
import org.bootcamp.concurrency.RunConcurrency;

import static org.bootcamp.Workbook11.Position.*;

public class Main {

    public static void main(String[] args) {

       RunConcurrency.run();

        //RunTrading.run();

//        Team bulls = new Team("Chicago Bulls");
//
//        bulls.setPlayer(SHOOTING_GUARD, "Michael Jordan");
//        bulls.setPlayer(SMALL_FORWARD, "Scottie Pippen");
//        bulls.setPlayer(POWER_FORWARD, "Dennis Rodman");
//        bulls.setPlayer(CENTER, "Bill Wennington");
//        bulls.setPlayer(POINT_GUARD, "Randy Brown");
//
//        Team pistons = new Team("Detroit Pistons");
//
//        pistons.setPlayer(SHOOTING_GUARD, "Joe Dumars");
//        pistons.setPlayer(SMALL_FORWARD, "Grant Hill");
//        pistons.setPlayer(POWER_FORWARD, "Otis Thorpe");
//        pistons.setPlayer(CENTER, "William Bedford");
//        pistons.setPlayer(POINT_GUARD, "Isiah Thomas");
//
//        Game game = new Game("arena");
//
//        game.begin(bulls, pistons);
    }
}