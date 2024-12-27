package Piece;

import Color.Color;
import Game.Board;

public class King extends Piece {


    public King(Color color) {
        super(PieceType.KING, color);
    }


    @Override
    public void move(int x, int y, int newX, int newY, Board board) {

        x = board.getX(this);
        y = board.getY(this);

        if (newX == x && newY == y + 1 || newX == x && newY == y - 1 || newX == x - 1 && newY == y || newX == x + 1 && newY == y) {
            return;
        }

        if (newX == x + 1 && newY == y + 1 || newX == x + 1 && newY == y - 1 || newX == x - 1 && newY == y + 1 || newX == x - 1 && newY == y - 1) {
            return;
        }
    }

    @Override
    public void catchPiece(int x, int y, int newX, int newY, Board board) {

        move(x, y, newX, newY, board);
    }
}


