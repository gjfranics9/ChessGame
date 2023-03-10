package Classes;
import java.awt.*;

import javax.swing.JFrame;
/**
 * @author George Francis
 * @version 0.15
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
    //board is a 2D array containing spots. Each spot can contain a piece.
    private spot[][] Board;

    public game(){
        Board = new spot[9][9];
        fillBoard();
    }

    //Fills the board with all the spots (8x8 standard chess board)
    public void fillBoard(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                spot tempSpot = new spot(i,j);
                Board[i][j] = tempSpot;
            }
        }
    }

    public spot[][] getBoard(){
        return Board;
    }

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