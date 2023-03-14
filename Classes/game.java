package Classes;
import java.awt.*;

import javax.swing.JFrame;
/**
 * @author George Francis
 * @version 0.16
 * 
 */
/*
 * Notes for developer
 * 
 * Game class
 * This is where the game is run.
 * 
 * There must be an initalisation where the pieces are set on a board
 * This is where the game is drawn on.
 * The game must alternate between players turns where only the corresponding player colour can move pieces
 * The game can have bonus features such as material counts
 * The game must be over once a win condition is met
 * There must be a resignation button
 * 
 */
public class game{
    board Board;

    //Board is created and all the squares are placed onto board
    public game(){
        Board = new board();
        Board.fillBoard();
    }

    //Used so that only game method needs to be passed
    public board getBoard(){
        return Board;
    }

    //Initialises canvas
    public void gameStart(){
        //initialise screen
        int w = 800;
        int h = 800;
        JFrame f = new JFrame();
        canvas myCanvas = new canvas(800,800,Board);
        f.setSize(w,h);
        f.setTitle("Chess");
        f.add(myCanvas);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String args[]){
        game Game = new game();
        Game.gameStart();
    }

}