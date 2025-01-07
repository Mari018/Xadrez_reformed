package piece;

import color.Color;

public class Queen extends Piece {


    public Queen(Color color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public boolean move(int x, int y, int newX, int newY) {


        if (newX == x) {
            int direction = (newY < y) ? 1 : -1;
            for (int i = y + direction; i >= newY; i--) {
                if (i == newY){
                   return true;
                }
            }
            return true;
        }
        if (newY == y) {
            int direction = (newX < x) ? 1 : - 1;
            for (int i = x + direction; i <= newX ; i++) {
                if (i == newX){
                    return true;
                }
            }
            return true;
        }
        if (Math.abs(newX - x) == Math.abs(newY - y)){
            int direction = (newX < x) ? 1 : - 1;
            int direction1 = (newY < y) ? 1 : -1;
            for (int i = x + direction; i <= newX; i++) {
                for (int j = y + direction1; j <= newY ; j++) {
                    if (i == newX && j == newY){
                        return true;
                    }
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
