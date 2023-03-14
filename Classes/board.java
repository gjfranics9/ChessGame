package Classes;
/**
 * @author George Francis
 * @version 0.01
 */
import java.awt.*;
class board{
    //squares is a 2D array containing spots. Each spot can contain a piece.
    private spot[][] squares;

    public board(){
        squares = new spot[9][9];
    }

    //Fills the board with all the spots (8x8 standard chess board)
    public void fillBoard(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                spot tempSpot = new spot(i,j);
                tempSpot.setBoard(this);
                squares[i][j] = tempSpot;
            }
        }
    }
    public spot getSquare(int row, int col){
        return squares[row][col];
    }
    public void drawBoard(Graphics2D g2d){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                spot tempSpot = this.getSquare(i,j);
                tempSpot.drawSelf(g2d);
            }
        }
    }
}