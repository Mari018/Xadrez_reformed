package piece;

import color.Color;

public class Rook extends Piece {


    public Rook(Color color) {
        super(PieceType.ROOK, color);
    }

    @Override
    public boolean move(int x, int y, int newX, int newY) {

        if (newX == x) {
            int direction = (newY < y) ? 1 : -1;
            for (int i = y + direction; i >= newY; i--) {
                if (i == newY) {
                    return true;
                }
            }
            return true;
        }
        if (newY == y) {
            int direction = (newX < x) ? 1 : -1;
            for (int i = x + direction; i <= newX; i++) {
                if (i == newX) {
                    return true;
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean catchPiece(int x, int y, int newX, int newY) {
        return false;
    }
}
