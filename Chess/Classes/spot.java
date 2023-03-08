package Classes;
/**
 * @author George Francis
 * @version 0.01
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
    
    public spot(int spotX, int spotY){
        this.spotX = spotX;
        this.spotY = spotY;
        this.Piece = null;
    }

    public void insertPiece(piece Piece){
        this.Piece = Piece;
    }

    public piece getPiece(){
        return this.Piece;
    }




}
