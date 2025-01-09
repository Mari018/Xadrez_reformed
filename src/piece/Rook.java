package piece;

import color.Color;

public class Rook extends Piece {


    public Rook(Color color) {
        super(PieceType.ROOK, color);
    }

    @Override
    public boolean move(int x, int y, int newX, int newY) {


        if (newX == x) {
            if (newY < y) {
                return true;
            } else if (newY > y) {
                return true;
            }
        }
        if (newY == y) {
            if (newX < x) {
                return true;
            } else if (newX > x) {
                return true;
            }
        }

            return false;

    }

    @Override
    public boolean catchPiece(int x, int y, int newX, int newY) {
        return false;
    }
}
