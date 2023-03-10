package Classes;
import java.awt.*;
import java.awt.geom.*;

/**
 * @author George Francis
 * @version 0.02
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
        g2d.fill(r);
    }

}
