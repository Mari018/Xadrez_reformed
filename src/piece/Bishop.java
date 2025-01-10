package piece;

import color.Color;

public class Bishop extends Piece {


    public Bishop(Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean move(int x, int y, int newX, int newY) {

        if (Math.abs(newX - x) == Math.abs(newY - y)) {
            if (newX > x && newY < y) {
                return true;
            } else if (newX > x && newY > y) {
                return true;
            } else if (newX < x && newY < y) {
                return true;
            } else if (newX < x && newY > y) {
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
