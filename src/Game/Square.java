package Game;

import Color.Color;
import Piece.Piece;

public class Square {

    // Receive the pieces
    // each square can be black or white

    private Piece piece;
    private Color color;

    public Square(int x, int y) {

        squareColor(x,y);
        piece = null;
    }

    // Giving the color to the square
    private void squareColor(int x, int y){

        if((x + y) % 2 == 0){
            color = Color.WHITE;
        } else{
            color = Color.BLACK;
        }
    }

    // Get´s the piece of the current square
    public Piece getCurrPiece(){
        return piece;
    }

    // Get´s the color of the square
    public Color getColor(){
        return color;
    }

    // Set´s the piece on the square
    public void setPiece(Piece piece){
        this.piece = piece;
    }
}
