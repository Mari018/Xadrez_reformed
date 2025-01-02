package Piece;

import Color.Color;
import Game.Board;

public class Queen extends Piece{


    public Queen(Color color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public void move(int x, int y, int newX, int newY, Board board) {

    }

    @Override
    public void catchPiece(int x, int y, int newX, int newY, Board board) {

    }
}
