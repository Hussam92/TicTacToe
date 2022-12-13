package com.itani.game;

import java.util.Scanner;

public class TicTacToeReader {

    // Method that prints available fields
    public static void printAvailableFields(TicTacToe ticTacToe) {
        // Print the available fields

        char[][] field = ticTacToe.getAvailableFields();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == ' ') {
                    System.out.print(i + " " + j + ", ");
                }
            }
        }

        System.out.println();
    }

    public static void getPlayerMove(TicTacToe ticTacToe, char player, Scanner input) {
        // Get the player's move
        printAvailableFields(ticTacToe);
        System.out.println("Enter the row and column of your move: ");
        int row = input.nextInt();
        int column = input.nextInt();

        try {
            ticTacToe.placeCharacter(row, column, player);
        } catch (Exception e) {
            System.out.println("Invalid move: ");
            getPlayerMove(ticTacToe, player, input);
        }

    }    
}
