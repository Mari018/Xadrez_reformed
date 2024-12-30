package Game;

import Color.Color;
import Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    // Have an array of players
    // Receives the board

    private Player[] players;
    private Board board;


    public Game() {
        players = new Player[2];
        players[0] = new Player("Mário");
        players[1] = new Player("Inês");

        board = new Board(players);
    }

    // Start the game
    public void start() {
        chooseWhtPlayer();
        board.addAllPieces(players[0]);
        board.addAllPieces(players[1]);
        game();
        winner();
    }

    private void game() {
        Scanner scanner = new Scanner(System.in);
        int turn = 0;

        while (!winner()) {
            try {
                // Always print the board actualized before the player movement
                board.printBoard();

                // Shows who is playing on players (0 is for player1 and 1 for player 2)
                Player playerMovement = players[turn % 2];
                System.out.println(playerMovement.getName() + " turn!");

                // Writing the coordinates we want to move from to the next position
                System.out.print("Enter the coordinates of the piece you want to move: ");
                String from = scanner.next();
                System.out.print("Enter where you want to move the piece: ");
                String to = scanner.next();

                //Switches the coordinates to index
                int fromX = from.charAt(0) - 'A';
                int fromY = Integer.parseInt(from.substring(1)) - 1;

                int toX = to.charAt(0) - 'A';
                int toY = Integer.parseInt(to.substring(1)) - 1;

                board.move(fromX, fromY, toX, toY);
                turn++;

            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Choose who starts
    private void chooseWhtPlayer() {
        int player1Move = players[0].rollTheDice();
        int player2Move = players[1].rollTheDice();
        players[0].setColor(Color.WHITE);
        players[1].setColor(Color.BLACK);

        System.out.println("Let's start!");
        System.out.println(players[0].getName() + " roll " + player1Move + " and " + players[1].getName() + " roll " + player2Move);

        if (player1Move == player2Move) {
            chooseWhtPlayer();
        }

        if (player1Move > player2Move) {
            System.out.println(players[0].getName() + " starts!\n");
        } else {
            System.out.println(players[1].getName() + " starts!\n");
            swapPlayer();
        }
    }

    // Swap if we need to change the player color
    private void swapPlayer() {
        Player swap = players[0];
        players[0] = players[1];
        players[1] = swap;
    }

    private boolean winner() {

        if (!players[0].isInCheck()) {
            System.out.println(players[0].getName() + " wins");
            return true;
        }

        if (!players[1].isInCheck()) {
            System.out.println(players[1].getName() + " wins");
            return true;
        }
        return false;
    }
}
