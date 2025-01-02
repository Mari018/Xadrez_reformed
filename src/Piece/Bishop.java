package Piece;

import Color.Color;
import Game.Board;

public class Bishop extends Piece{


    public Bishop( Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public void move(int x, int y, int newX, int newY, Board board) {

    }

    @Override
    public void catchPiece(int x, int y, int newX, int newY, Board board) {

    }
}
