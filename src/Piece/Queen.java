package Piece;

import Color.Color;
import Game.Board;

public class Queen extends Piece {


    public Queen(Color color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public boolean move(int x, int y, int newX, int newY) {


        if (newX == x && newY < y) {
            for (int i = y - 1; i > newY; i--) {
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
