package Piece;

import Color.Color;
import Game.Board;

public class Knight extends Piece {


    public Knight( Color color) {
        super(PieceType.KNIGHT, color);
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
