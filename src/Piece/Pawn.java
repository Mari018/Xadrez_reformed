package Piece;

import Color.Color;
import Game.Board;

public class Pawn extends Piece {

    // counter to count the first move
    private int move;


    public Pawn(Color color) {
        super(PieceType.PAWN, color);

    }

    @Override
    public void move(int x, int y, int newX, int newY, Board board) {

        x = board.getX(this);
        y = board.getY(this);

        // First move of the pawn he can move 2 or 1 squares at the time
        if (move == 0) {
            if (getColor() == Color.WHITE) {
                if (newX == x && newY == y + 2 || newX == x && newY == y + 1) {
                    move++;
                    return;
                }
            } else {
                if (getColor() == Color.BLACK) {
                    if (newX == x && newY == y - 2 || newX == x && newY == y - 1) {
                        move++;
                        return;
                    }
                }
            }
        } else {
            // Normal 1 square move
            if (getColor() == Color.WHITE) {
                if (newX == x && newY == y + 1) {
                    return;
                }
            } else {
                if (getColor() == Color.BLACK) {
                    if (newX == x && newY == y - 1) {
                        return;
                    }
                }
            }
        }
    }

    // Pawn have a different move when he can catch a piece
    @Override
    public void catchPiece(int x, int y, int newX, int newY, Board board) {

        x = board.getX(this);
        y = board.getY(this);

        if (getColor() == Color.WHITE) {
            if (newX == x - 1 && newY == y + 1 || newX == x + 1 && newY == y + 1) {
                return;
            }
        } else {
            if (getColor() == Color.BLACK) {
                if (newX == x - 1 && newY == y - 1 || newX == x + 1 && newY == y - 1) {
                    return;
                }
            }
        }
    }
}
