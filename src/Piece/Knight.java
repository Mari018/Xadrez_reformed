package Piece;

import Color.Color;
import Game.Board;

public class Knight extends Piece {


    public Knight(Color color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public boolean move(int x, int y, int newX, int newY) {

        if (getColor() == Color.WHITE) {
            if (newX == x + 2 && newY == y + 1 || newX == x + 2 && newY == y - 1) {
                return true;
            }
        }

        if (getColor() == Color.BLACK) {
            if (newX == x - 2 && newY == y + 1 || newX == x - 2 && newY == y + 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean catchPiece(int x, int y, int newX, int newY) {

        if (move(x, y, newX, newY)){
            return true;
        }

        return false;
    }
}
