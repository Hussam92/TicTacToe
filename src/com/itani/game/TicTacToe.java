package com.itani.game;

// TicTacToe class implementation
public class TicTacToe {

    // TicTacToe field
    private char[][] field = new char[3][3];

    // TicTacToe constructor
    public TicTacToe() {
        // Initialize the field
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = ' ';
            }
        }
    }

    /**
     * Returns the character of the player who won
     * If it is a draw, returns 'D'
     * If game is not over, returns ' '
     */
    public char gameOver()
    {
        // Check if there is a winner
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2]) {
                return field[i][0];
            }
        }

        // Check if there is a winner
        for (int i = 0; i < 3; i++) {
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i]) {
                return field[0][i];
            }
        }

        // Check if there is a winner
        if (field[0][0] == field[1][1] && field[0][0] == field[2][2]) {
            return field[0][0];
        }

        // Check if there is a winner
        if (field[0][2] == field[1][1] && field[0][2] == field[2][0]) {
            return field[0][2];
        }

        // Check if there is a draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == ' ') {
                    return ' ';
                }
            }
        }

        // Return draw
        return 'D';
    }

    // method that returns the available fields to play on
    public char[][] getAvailableFields() {
        // Create a new field
        char[][] availableFields = new char[3][3];

        // Copy the field
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                availableFields[i][j] = field[i][j];
            }
        }

        // Return the available fields
        return availableFields;
    }

    // method that accepts coordinates and places character on the field
    public void placeCharacter(int x, int y, char character) {
        // Place the character
        // throw error if field is not empty
        if (field[x][y] != ' ') {
            throw new IllegalArgumentException("Field is not empty");
        }

        field[x][y] = character;
    }

    // method that prints the field
    public void printField() {
        // print the field
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
                if(j<field.length-1){
                    System.out.print("|");
                }
            }
            if(i<field.length-1){
                System.out.println("\n------");
            } else {
                System.out.println();
            }
        }
    }

    // method that prints congratulation message
    public void printWinner(char winner) {
        // print the winner
        if (winner == 'X') {
            System.out.println("Player X won!");
        } else if (winner == 'O') {
            System.out.println("Player O won!");
        } else if (winner == 'D') {
            System.out.println("It's a draw!");
        }
    }
}