package com.itani.game;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        game.placeCharacter(1, 1, 'O');
        game.placeCharacter(2, 2, 'X');

        game.printField();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i = s.nextInt();
        System.out.println("You entered: " + i);
        s.close();
    }
}
