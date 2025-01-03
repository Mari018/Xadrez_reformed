package Piece;

import Color.Color;
import Game.Board;

public class Rook extends Piece{


    public Rook(Color color) {
        super(PieceType.ROOK, color);
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
