package Classes;
import java.util.ArrayList;
/**
 * @author George Francis
 * @version 0.00
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
    //board is an ArrayList containing the pieces. Will worry about clashing positions later (checkPositions method)
    private spot[][] Board;

    public game(){
        fillBoard();
    }

    public void fillBoard(){
    }

    public void gameStart(){
        fillBoard();
    }

    public static void main(String args[]){
        game Game = new game();
        Game.gameStart();
    }
}