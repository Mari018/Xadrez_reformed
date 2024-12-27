package Piece;

import Color.Color;
import Game.Board;

public abstract class Piece {

    // Piece.Piece receive his type
    // Receive is color

    protected PieceType type;
    protected Color color;

    public Piece(PieceType type, Color color){

        this.type = type;
        this.color = color;
    }

    // Method move to all pieces
    public abstract void move(int x, int y, int newX,int newY, Board board);

    // Method to catch the opponent piece
    public abstract void catchPiece(int x, int y, int newX,int newY, Board board);

    public Color getColor(){
        return color;
    }
}