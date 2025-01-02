package Piece;

import Color.Color;
import Game.Board;

public class Knight extends Piece {


    public Knight( Color color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public void move(int x, int y, int newX, int newY, Board board) {

    }

    @Override
    public void catchPiece(int x, int y, int newX, int newY, Board board) {

    }
}
