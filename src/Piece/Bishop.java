package Piece;

import Color.Color;
import Game.Board;

public class Bishop extends Piece {


    public Bishop(Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean move(int x, int y, int newX, int newY) {

        if (Math.abs(newX - x) == Math.abs(newY - y)) {
            int direction = (newX < x) ? 1 : -1;
            int direction1 = (newY < y) ? 1 : -1;
            for (int i = x + direction; i <= newX; i++) {
                for (int j = y + direction1; j <= newY; j++) {
                    if (i == newX && j == newY) {
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
