package piece;

import color.Color;

public class Queen extends Piece {


    public Queen(Color color) {
        super(PieceType.QUEEN, color);
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
        if (Math.abs(newX - x) == Math.abs(newY - y)) {
            if (newX < x && newY < y) {
                return true;
            } else if (newX > x && newY > y) {
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
