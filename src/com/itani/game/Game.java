package com.itani.game;

import java.util.Scanner;

public class Game {

    // TicTacToe field  
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';

    // TicTacToe game
    public static void main(String[] args) {
        // Create a new game
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);
        char currentPlayer = PLAYER_X;
        // Start the game
        // Loop until game is over
        while (game.gameOver() == ' ') {
            // Print the field
            game.printField();
            TicTacToeReader.getPlayerMove(game, currentPlayer, input);
            
            currentPlayer = swapPlayers(currentPlayer);
        }

        game.printWinner(game.gameOver());
        input.close();
    }

    // method to swap players
    public static char swapPlayers(char currentPlayer) {
        if (currentPlayer == PLAYER_X) {
            return PLAYER_O;
        } else {
            return PLAYER_X;
        }
    }
}