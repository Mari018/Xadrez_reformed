package Piece;

import Color.Color;
import Game.Board;

public class Bishop extends Piece{


    public Bishop( Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean move(int x, int y, int newX, int newY) {
return false;
    }

    @Override
    public boolean catchPiece(int x, int y, int newX, int newY) {
return false;
    }
}