import java.util.Scanner;

import com.itani.game.TicTacToe;
import com.itani.game.TicTacToeReader;
import com.itani.gui.GameUI;

public class Game {

    // TicTacToe field  
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';

    public static TicTacToe ticTacToe;


    // TicTacToe game
    public static void main(String[] args) {
        // Create a new game
        Scanner input = new Scanner(System.in);

        GameUI gui = new GameUI();
        gui.buildGUI();
        gui.showGUI();
        
        char currentPlayer = PLAYER_X;
        // Start the game
        // Loop until game is over
        while (Game.ticTacToe.gameOver() == ' ') {
            // Print the field
            Game.ticTacToe.printField();
            TicTacToeReader.getPlayerMove(Game.ticTacToe, currentPlayer, input);
            
            currentPlayer = swapPlayers(currentPlayer);
        }

        Game.ticTacToe.printWinner(Game.ticTacToe.gameOver());
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

    public static void startGame()
    {
        Game.ticTacToe = new TicTacToe();
    }
}