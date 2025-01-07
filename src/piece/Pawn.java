package piece;

import color.Color;

public class Pawn extends Piece {

    // counter to count the first move
    private int move;


    public Pawn(Color color) {
        super(PieceType.PAWN, color);

    }

    @Override
    public boolean move(int x, int y, int newX, int newY) {


        // First move of the pawn he can move 2 or 1 squares at the time
        if (move == 0) {
            if (getColor() == Color.WHITE) {
                if (newX == x + 2 && newY == y || newX == x + 1 && newY == y) {
                    move++;
                    return true;
                }
            }

            if (getColor() == Color.BLACK) {
                if (newX == x - 2 && newY == y || newX == x - 1 && newY == y) {
                    move++;
                    return true;
                }
            }

        }
        if (getColor() == Color.WHITE) {
            if (newX == x + 1 && newY == y) {
                return true;
            }
        }
        if (getColor() == Color.BLACK) {
            if (newX == x - 1 && newY == y) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean catchPiece(int x, int y, int newX, int newY) {
        if (getColor() == Color.WHITE) {
            if (newX == x + 1 && newY == y - 1 || newX == x + 1 && newY == y + 1) {
                return true;
            }
        }
        if (getColor() == Color.BLACK) {
            if (newX == x - 1 && newY == y - 1 || newX == x - 1 && newY == y + 1) {
                return true;
            }
        }

        return false;


    }


}
