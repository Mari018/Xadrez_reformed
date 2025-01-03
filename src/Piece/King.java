package Piece;

import Color.Color;
import Game.Board;

public class King extends Piece {


    public King(Color color) {
        super(PieceType.KING, color);
    }


    @Override
    public boolean move(int x, int y, int newX, int newY) {


        if (newX == x && newY == y + 1 || newX == x && newY == y - 1 || newX == x - 1 && newY == y || newX == x + 1 && newY == y) {
            return true;
        }

        if (newX == x + 1 && newY == y + 1 || newX == x + 1 && newY == y - 1 || newX == x - 1 && newY == y + 1 || newX == x - 1 && newY == y - 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean catchPiece(int x, int y, int newX, int newY) {

       if(!move(x, y, newX, newY)){
           move(x,y,newX,newY);
           return true;
       }
       return false;
    }
}


