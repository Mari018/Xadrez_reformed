package game;

import color.Color;
import piece.Piece;
import player.Player;
import piece.Pawn;
import piece.King;
import piece.Bishop;
import piece.Knight;
import piece.Queen;
import piece.Rook;

import java.util.ArrayList;

public class Board {

    // Receive an array of players
    // Receives the Squares to make the board
    // Have an array for the captured pieces

    private Player[] players;
    private Square[][] board;
    private ArrayList<Piece> captured = new ArrayList<>();
    private static final char[] row = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private static final int[] col = {1, 2, 3, 4, 5, 6, 7, 8};

    public Board(Player[] players) {

        this.players = players;
        createBoard();

    }

    // Create a 8x8 board game
    private void createBoard() {

        board = new Square[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square(row[i], col[j]);
            }
        }
    }

    // Add all the pieces and giving to the player
    public void addAllPieces(Player player) {
        addPawns(player);
        addKing(player);
        addQueen(player);
        addBishop(player);
        addKnight(player);
        addRook(player);
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

    // Add the Rooks
    private void addRook(Player player) {
        Color playerColor = player.getColor();
        Piece piece;
        Piece piece1;

        if (playerColor == Color.WHITE) {
            piece = new Rook(Color.WHITE);
            piece1 = new Rook(Color.WHITE);
            board[0][0].setPiece(piece);
            board[0][7].setPiece(piece1);
            player.getOwnPieces().add(piece);
            player.getOwnPieces().add(piece1);
        } else {
            if (playerColor == Color.BLACK) {
                piece = new Rook(Color.BLACK);
                piece1 = new Rook(Color.BLACK);
                board[7][0].setPiece(piece);
                board[7][7].setPiece(piece1);
                player.getOwnPieces().add(piece);
                player.getOwnPieces().add(piece1);
            }
        }
    }

    // Add the Queens
    private void addQueen(Player player) {
        Color playerColor = player.getColor();
        Piece piece;


        if (playerColor == Color.WHITE) {
            piece = new Queen(Color.WHITE);
            board[0][3].setPiece(piece);
            player.getOwnPieces().add(piece);
        } else {
            if (playerColor == Color.BLACK) {
                piece = new Queen(Color.BLACK);
                board[7][4].setPiece(piece);
                player.getOwnPieces().add(piece);
            }
        }
    }

    // Add the Knights
    private void addKnight(Player player) {
        Color playerColor = player.getColor();
        Piece piece;
        Piece piece1;

        if (playerColor == Color.WHITE) {
            piece = new Knight(Color.WHITE);
            piece1 = new Knight(Color.WHITE);
            board[0][1].setPiece(piece);
            board[0][6].setPiece(piece1);
            player.getOwnPieces().add(piece);
            player.getOwnPieces().add(piece1);
        } else {
            if (playerColor == Color.BLACK) {
                piece = new Knight(Color.BLACK);
                piece1 = new Knight(Color.BLACK);
                board[7][1].setPiece(piece);
                board[7][6].setPiece(piece1);
                player.getOwnPieces().add(piece);
                player.getOwnPieces().add(piece1);
            }
        }
    }

    // Add the Bishops
    private void addBishop(Player player) {
        Color playerColor = player.getColor();
        Piece piece;
        Piece piece1;

        if (playerColor == Color.WHITE) {
            piece = new Bishop(Color.WHITE);
            piece1 = new Bishop(Color.WHITE);
            board[0][2].setPiece(piece);
            board[0][5].setPiece(piece1);
            player.getOwnPieces().add(piece);
            player.getOwnPieces().add(piece1);
        } else {
            if (playerColor == Color.BLACK) {
                piece = new Bishop(Color.BLACK);
                piece1 = new Bishop(Color.BLACK);
                board[7][2].setPiece(piece);
                board[7][5].setPiece(piece1);
                player.getOwnPieces().add(piece);
                player.getOwnPieces().add(piece1);
            }
        }
    }

    // Print the board
    public void printBoard() {

        // Loop to print all the positions on the 2D array
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

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
                if (piece instanceof Bishop) {
                    if (piece.getColor() == Color.WHITE) {
                        System.out.print(" wB");
                    } else {
                        System.out.print(" bB");
                    }
                }
                if (piece instanceof Knight) {
                    if (piece.getColor() == Color.WHITE) {
                        System.out.print(" wk");
                    } else {
                        System.out.print(" bk");
                    }
                }
                if (piece instanceof Queen) {
                    if (piece.getColor() == Color.WHITE) {
                        System.out.print(" wQ");
                    } else {
                        System.out.print(" bQ");
                    }
                }
                if (piece instanceof Rook) {
                    if (piece.getColor() == Color.WHITE) {
                        System.out.print(" wR");
                    } else {
                        System.out.print(" bR");
                    }
                }
            }
            // Print the numbers of the coordinates
            System.out.print(" ");
            System.out.println(row[i]);
        }
        // Print the letters of the coordinates
        for (int i = 0; i < board.length; i++) {
            System.out.print(" " + col[i] + " ");
        }
        System.out.println("\n");
    }

    // Check if the position is empty
    private boolean isEmpty(int x, int y) {

        return board[x][y].getCurrPiece() == null;
    }

    public Square getSquare(int x, int y) {
        return board[x][y];
    }

    public ArrayList<Piece> getCaptured() {
        return captured;
    }

    // Checks if the currPiece can catch the piece on the new position
    // if he can catch remove to the player who lost the piece
    // Add to the caught array
    public boolean isCatchable(int x, int y, int newX, int newY) {

        if (getSquare(newX, newY) != null) {
            if (getSquare(x, y).getCurrPiece().getColor() == Color.WHITE)
                if (getSquare(x, y).getCurrPiece().getColor() != getSquare(newX, newY).getCurrPiece().getColor()) {
                    players[1].getOwnPieces().remove(getSquare(newX, newY).getCurrPiece());
                    getCaptured().add(getSquare(newX, newY).getCurrPiece());
                    return true;
                }

            if (getSquare(x, y).getCurrPiece().getColor() == Color.BLACK) {
                if (getSquare(x, y).getCurrPiece().getColor() != getSquare(newX, newY).getCurrPiece().getColor()) {
                    players[0].getOwnPieces().remove(getSquare(newX, newY).getCurrPiece());
                    getCaptured().add(getSquare(newX, newY).getCurrPiece());
                    return true;
                }

            }
        }


        return false;
    }

    // Board checks if the piece can move to the new position
    public boolean move(int x, int y, int newX, int newY) {
        Piece piece = getSquare(x, y).getCurrPiece();

        // First check if we have a piece on that square
        if (getSquare(x, y).getCurrPiece() == null) {
            return false;
        }

        if (piece instanceof Queen || piece instanceof Rook || piece instanceof Bishop) {
            if (piece.move(x, y, newX, newY)) {
                if (checkPath(x, y, newX, newY)) {

                    getSquare(newX, newY).setPiece(piece);
                    getSquare(x, y).setPiece(null);
                    return true;
                }
            }
            return false;
        }
        // Set piece on an empty spot
        if (piece.move(x, y, newX, newY) && isEmpty(newX, newY)) {

            getSquare(newX, newY).setPiece(piece);
            getSquare(x, y).setPiece(null);
            return true;

        }

        // Catch a piece
        if (piece.catchPiece(x, y, newX, newY) && !isEmpty(newX, newY) && isCatchable(x, y, newX, newY)) {

            getSquare(newX, newY).setPiece(piece);
            getSquare(x, y).setPiece(null);
            return true;

        }

        // If the move is illegal
        // Call again the method move
        System.out.println("can't move");
        return false;
    }

    private boolean checkPath(int x, int y, int newX, int newY) {
        // Last position
        if (x == newX && y == newY) {
            return true;
        }

        // Move just on the col
        if (x == newX) {
            int direction = (newY > y) ? 1 : -1;
            int nextY = y + direction;

            // IF the next position is occupied return false
            if (!isEmpty(x, nextY)) {
                return false;
            }
            if (!isEmpty(newX, newY) && isCatchable(x,y,newX,newY)){
                return true;
            }

            // Recursion
            return checkPath(x, nextY, newX, newY);
        }

        // Move on the row
        if (y == newY) {
            int direction = (newX > x) ? 1 : -1;
            int nextX = x + direction;

            // Check if the next position is occupied
            if (!isEmpty(nextX, y)) {
                return false;
            }
            if (!isEmpty(newX, newY) && isCatchable(x,y,newX,newY)){
                return true;
            }

            // Recursion
            return checkPath(nextX, y, newX, newY);
        }

        // Move on the diagonal
        if (Math.abs(newX - x) == Math.abs(newY - y)) {
            int directionX = (newX > x) ? 1 : -1;
            int directionY = (newY > y) ? 1 : -1;

            int nextX = x + directionX;
            int nextY = y + directionY;

            // Check if its empty
            if (!isEmpty(nextX, nextY)) {
                return false;
            }
            if (!isEmpty(newX, newY) && isCatchable(x,y,newX,newY)){
                return true;
            }

            // Recursion
            return checkPath(nextX, nextY, newX, newY);
        }

        return false;
    }


}

