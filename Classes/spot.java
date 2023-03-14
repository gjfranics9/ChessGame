package Classes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Point;

/**
 * Represents a spot on the board where a piece can be placed.
 */
public class spot {
    private final Point position;
    private piece Piece;
    private board Board;
    
    /**
     * Creates a new spot with the specified position.
     *
     * @param x The x coordinate of the spot.
     * @param y The y coordinate of the spot.
     */
    public spot(int x, int y) {
        position = new Point(x, y);
        Piece = null;
    }

    /**
     * Places a piece on this spot.
     *
     * @param insertedPiece The piece to place on this spot.
     */
    public void insertPiece(piece insertedPiece) {
        Piece = insertedPiece;
    }

    /**
     * Returns the piece object that is on this spot.
     *
     * @return The piece on this spot, or null if there is no piece.
     */
    public piece getPiece() {
        return Piece;
    }

    /**
     * Sets the board that this spot is on.
     *
     * @param boardInput The board that this spot is on.
     */
    public void setBoard(board boardInput) {
        Board = boardInput;
    }

    /**
     * Returns the board that this spot is on.
     *
     * @return The board that this spot is on.
     */
    public board getBoard() {
        return Board;
    }

    /**
     * Receives a piece from another spot and takes it.
     *
     * @param otherSpot The spot from which to receive the piece.
     */
    public void receivePiece(spot otherSpot) {
        insertPiece(otherSpot.getPiece());
        otherSpot.insertPiece(null);
    }

    /**
     * Returns the x coordinate of this spot on the screen.
     *
     * @return The x coordinate of this spot on the screen.
     */
    public int getScreenX() {
        return 100 * (position.x - 1);
    }

    /**
     * Returns the y coordinate of this spot on the screen.
     *
     * @return The y coordinate of this spot on the screen.
     */
    public int getScreenY() {
        return 100 * (position.y - 1);
    }

    /**
     * Draws this spot on the specified graphics context.
     *
     * @param g2d The graphics context on which to draw this spot.
     */
    public void drawSelf(Graphics2D g2d) {
        int screenX = getScreenX();
        int screenY = getScreenY();
        Rectangle2D.Double r = new Rectangle2D.Double(screenX, screenY, 100, 100);
        boolean isBlack = (position.y % 2 == 1 && position.x % 2 == 0) || (position.y % 2 == 0 && position.x % 2 == 1);
        if(isBlack){
            g2d.setColor(Color.BLACK);
            g2d.fill(r);
        }
        /*
        else{
            g2d.setColor(new Color(150, 111, 51));
            g2d.fill(r);
        }
        */
        
    }
}

