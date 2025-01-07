package player;

import color.Color;
import piece.Piece;

import java.util.ArrayList;

public class Player {

    // Player.Player have a list of pieces that he can use to play
    // Have a color that determinate what pieces he will receive
    // Have a name

    private String name;
    private Color color;
    private ArrayList<Piece> ownPieces = new ArrayList<>();
    private boolean inCheck;

    public Player(String name){
        this.name = name;

    }

    // Choose which player will start
    public int rollTheDice(){
        int min = 1;
        int max = 6;

        return (int) (Math.random()* (max - min + 1) + min);
    }

    public Color getColor(){
        return color;
    }

    // Set the color depends on who has the higher roller
    public void setColor(Color color){
        this.color = color;
    }

    public String getName(){
        return name;
    }

    // list of pieces he can still use
    public ArrayList<Piece> getOwnPieces(){
        return ownPieces;
    }

    public boolean isInCheck(){
        return inCheck = true;
    }
}
