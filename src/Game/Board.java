package Game;

import Color.Color;
import Piece.Piece;
import Player.Player;
import Piece.Pawn;
import Piece.King;

import java.util.ArrayList;

public class Board {

    // Receive an array of players
    // Receives the Squares to make the board
    // Have an array for the captured pieces

    private Player[] players;
    private Square[][] board;
    private ArrayList<Piece> captured = new ArrayList<>();
    private static final char[] x = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private static final int[] y = {1, 2, 3, 4, 5, 6, 7, 8};

    public Board(Player[] players) {

        this.players = players;
        createBoard();

    }

    // Create a 8x8 board game
    private void createBoard() {

        board = new Square[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square(x[i], y[j]);
            }
        }
    }

    // Add all the pieces and giving to the player
    public void addAllPieces(Player player) {
        addPawns(player);
        addKing(player);
    }

    // Add the pawns to the game and to the player
    private void addPawns(Player player) {
        Color playerColor = player.getColor();
        Piece piece;

        if (playerColor == Color.WHITE) {
            for (int i = 0; i < board.length; i++) {
                piece = new Pawn(Color.WHITE);
                board[1][i].setPiece(piece);
                player.getOwnPieces().add(piece);
            }
        } else {
            if (playerColor == Color.BLACK) {
                for (int i = 0; i < board.length; i++) {
                    piece = new Pawn(Color.BLACK);
                    board[6][i].setPiece(piece);
                    player.getOwnPieces().add(piece);
                }
            }
        }
    }

    // Adding the Kings to the board and to the players
    private void addKing(Player player) {
        Color playerColor = player.getColor();
        Piece piece;

        if (playerColor == Color.WHITE) {
            piece = new King(Color.WHITE);
            board[0][4].setPiece(piece);
            player.getOwnPieces().add(piece);
        } else {
            if (playerColor == Color.BLACK) {
                piece = new King(Color.BLACK);
                board[7][3].setPiece(piece);
                player.getOwnPieces().add(piece);
            }
        }
    }

    // Print the board
    public void printBoard() {

        // Loop to print all the positions on the 2D array
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                Piece piece = board[i][j].getCurrPiece();

                // Check the empty space do print the squares
                if (piece == null) {
                    if (board[i][j].getColor() == Color.WHITE) {
                        System.out.print("   ");
                    } else {
                        System.out.print(" &&");
                    }
                }
                if (piece instanceof Pawn) {
                    if (piece.getColor() == Color.WHITE) {
                        System.out.print(" wP");
                    } else {
                        System.out.print(" bP");
                    }
                }
                if (piece instanceof King) {
                    if (piece.getColor() == Color.WHITE) {
                        System.out.print(" wK");
                    } else {
                        System.out.print(" bK");
                    }
                }
            }
            // Print the numbers of the coordinates
            System.out.print(" ");
            System.out.println(x[i]);
        }
        // Print the letters of the coordinates
        for (int i = 0; i < board.length; i++) {
            System.out.print(" " + y[i] + " ");
        }
        System.out.println("\n");
    }

    // Check if the position is empty
    private boolean isEmpty(int x, int y) {

        return board[x][y].getCurrPiece() == null;
    }

    // So we can´t move out of the board
    private boolean outOfBoard(int x, int y) {
        if (x < 0 || x > 7) {
            return true;
        }

        if (y < 0 || y > 7) {
            return true;
        }

        return false;

    }

    public Square getSquare(int x, int y) {
        return board[x][y];
    }

    public ArrayList<Piece> getCaptured() {
        return captured;
    }

    // Return the position on the x-axis
    public int getX(Piece piece) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getCurrPiece() == null) {
                    continue;
                }

                if (board[i][j].getCurrPiece().equals(piece)) {
                    return i;
                }
            }

        }
        System.out.println("You don't have that piece on the board.");
        return 0;
    }

    // Return the position ont the y-axis
    public int getY(Piece piece) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getCurrPiece() == null) {
                    continue;
                }

                if (board[i][j].getCurrPiece().equals(piece)) {
                    return j;
                }
            }
        }
        System.out.println("You don't have that piece on the board.");
        return 0;
    }

    // Checks if the currPiece can catch the piece on the new position
    // if he can catch remove to the player who lost the piece
    // Add to the caught array
    public boolean isCatchable(int x, int y, int newX, int newY) {

        if (getSquare(x, y).getCurrPiece().getColor() == Color.WHITE)
            if (getSquare(x, y).getCurrPiece().getColor() != getSquare(newX, newY).getColor()) {
                players[1].getOwnPieces().remove(getSquare(newX, newY).getCurrPiece());
                getCaptured().add(getSquare(newX, newY).getCurrPiece());
                return true;
            }

        if (getSquare(x, y).getCurrPiece().getColor() == Color.BLACK) {
            if (getSquare(x, y).getCurrPiece().getColor() != getSquare(newX, newY).getColor()) {
                players[0].getOwnPieces().remove(getSquare(newX, newY).getCurrPiece());
                getCaptured().add(getSquare(newX, newY).getCurrPiece());
                return true;
            }
        }

        System.out.println(" You can´t capture your own piece.");
        return false;
    }

    // Game.Game.Board checks if the piece can move to the new position
    public void move(int x, int y, int newX, int newY) {
        Piece piece = getSquare(x, y).getCurrPiece();

        // First check if we have a piece on that square
        if (getSquare(x, y).getCurrPiece() == null) {
            System.out.println("You don't have a piece there.");
            move(x, y, newX, newY);
            return;
        }

        // Set piece on an empty spot
        if (isEmpty(newX, newY) || outOfBoard(newX, newY)) {
            piece.move(x, y, newX, newY, this);
            getSquare(newX, newY).setPiece(piece);
            getSquare(x, y).setPiece(null);
        }

        // Capture a piece
        else if (!isEmpty(newX, newY) && !isCatchable(x, y, newX, newY) || outOfBoard(newX, newY) && !isCatchable(x, y, newX, newY)) {
            piece.catchPiece(x, y, newX, newY, this);
            getSquare(newX, newY).setPiece(piece);
            getSquare(x, y).setPiece(null);


            // If the move is illegal
            // Call again the method move
        } else {
            System.out.println("You can´t move there.");

        }
    }

}

