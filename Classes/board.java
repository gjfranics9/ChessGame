package Classes;
/**
 * @author George Francis
 * @version 0.01
 */
import java.awt.*;
class board{
    //squares is a 2D array containing spots. Each spot can contain a piece.
    private spot[][] squares;

    /**
     * Creates a new board and makes new 2d array containing all spots
     * 
     */
    public board(){
        squares = new spot[8][8];
    }

    /**
     * Fills the board with all the spots (8x8 standard chess board)
     */

    public void fillBoard(){
        for(int row=0; row<8; row++){
            for(int col=0; col<8; col++){
                spot tempSpot = new spot(row,col);
                tempSpot.setBoard(this);
                squares[row][col] = tempSpot;
            }
        }
    }

    /**
     * Gets the squae of current specified position
     * @param row
     * @param col
     * @return Square assigned to the row and column
     */
    public spot getSquare(int row, int col){
        return squares[row][col];
    }
    /**
     * Draws each square in the board
     * @param g2d
     */
    public void drawBoard(Graphics2D g2d){
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                spot tempSpot = this.getSquare(row,col);
                tempSpot.drawSelf(g2d);
            }
        }
    }
}