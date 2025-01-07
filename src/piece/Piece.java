package piece;

import color.Color;

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
    public abstract boolean move(int x, int y, int newX,int newY);

    // Method to catch the opponent piece
    public abstract boolean catchPiece(int x, int y, int newX,int newY);

    public Color getColor(){
        return color;
    }
}
