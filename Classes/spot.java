package Classes;
import java.awt.*;
import java.awt.geom.*;

/**
 * @author George Francis
 * @version 0.10
 */
/*
 * spot is now the main class where pieces occur to avoid storing the coordinates multiple times.
 * Pieces individually do not know where they are and the movement of pieces is spots trading their positions.
 * spot should be the only class where x and y coordinates are stored
 * 
 * 
 */
public class spot {
    private int spotX;
    private int spotY;
    private piece Piece;
    private board Board;
    
    public spot(int X, int Y){
        spotX = X;
        spotY = Y;
        Piece = null;
    }

    //Places a piece on this square
    public void insertPiece(piece insertedPiece){
        Piece = insertedPiece;
    }

    //Gets the piece object that this square holds
    public piece getPiece(){
        return Piece;
    }

    //sets the board the spot is in
    public void setBoard(board boardInput){
        Board = boardInput;
    }
    //Returns the board it is in
    public board getBoard(){
        return Board;
    }

    //receives a piece from another square and takes it
    public void receivePiece(spot otherSpot){
        insertPiece(otherSpot.getPiece());
        otherSpot.insertPiece(null);
    }
    

    public int getScreenX(){
        return 100*(spotX-1);
    }

    public int getScreenY(){
        return 100*(spotY-1);
    }

    public void drawSelf(Graphics2D g2d){
        int screenX = this.getScreenX();
        int screenY = this.getScreenY();
        Rectangle2D.Double r = new Rectangle2D.Double(screenX, screenY, 100, 100);
        g2d.setColor(Color.BLACK);
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                if(spotY % 2 == 1 && spotX % 2 == 0){
                    g2d.fill(r);
                }
                else if(spotY% 2 == 0 && spotX % 2 == 1){
                    g2d.fill(r);
                }
            }

        }
    }
}
