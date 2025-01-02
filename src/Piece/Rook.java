package Piece;

import Color.Color;
import Game.Board;

public class Rook extends Piece{


    public Rook(Color color) {
        super(PieceType.ROOK, color);
    }

    @Override
    public void move(int x, int y, int newX, int newY, Board board) {

    }

    @Override
    public void catchPiece(int x, int y, int newX, int newY, Board board) {

    }
}
