package game;

import color.Color;
import piece.King;
import piece.Piece;
import piece.PieceType;
import player.Player;

import javax.swing.*;
import java.util.Scanner;


public class Game {

    // Have an array of players
    // Receives the board

    private Player[] players;
    private Board board;
    int turn = 0;


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


        while (!winner()) {
            try {
                // Always print the board actualized before the player movement
                board.printBoard();

                // Shows who is playing on players (0 is for player1 and 1 for player 2)
                Player playerMovement = players[turn % 2];
                System.out.println(playerMovement.getName() + " turn!");

                // Writing the coordinates we want to move from to the next position
                System.out.print("Enter the coordinates of the piece you want to move: ");
                String from = scanner.next().toUpperCase();
                if (from.equals("RESTART")) {
                    JOptionPane.showMessageDialog(null, "Are you sure?", null,
                            JOptionPane.INFORMATION_MESSAGE);
                    restart();
                } else {

                    System.out.print("Enter where you want to move the piece: ");
                    String to = scanner.next().toUpperCase();

                    //Switches the coordinates to index
                    int fromX = from.charAt(0) - 'A';
                    int fromY = Integer.parseInt(from.substring(1)) - 1;

                    int toX = to.charAt(0) - 'A';
                    int toY = Integer.parseInt(to.substring(1)) - 1;

                    if (!board.move(fromX, fromY, toX, toY)) {
                        game();
                    } else {
                        board.move(fromX, fromY, toX, toY);
                        turn++;
                    }
                }

            } catch (NumberFormatException e) {
                throw new RuntimeException(e);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void restart() throws Exception {
        start();
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
        boolean player1HasKing = players[0].getOwnPieces().stream().anyMatch(piece -> piece.getType().equals(PieceType.KING));
        boolean player2HasKing = players[1].getOwnPieces().stream().anyMatch(piece -> piece.getType().equals(PieceType.KING));

        if (!player2HasKing) {
            System.out.println(players[0].getName() + " wins");
            return true;
        }

        if (!player1HasKing) {
            System.out.println(players[1].getName() + " wins");
            return true;
        }
        return false;
    }
}
