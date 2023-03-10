package Classes;
/**
 * @author George Francis
 * @version 0.10
 */
/*
 * Notes for developer:
 * 
 * Super class for all pieces on the board (pieces also represents pawns in the code although contrary to chess terminology).
 * The class must be abstract as there can only be a specific type of piece and not a general 'piece' instance
 * 
 * Pieces now only contain which type they are - perhaps less need for separate classes for each piece
 */
public abstract class piece {

    private Boolean white;
    //pieces could perhaps not hold their own x and y coordinate and instead x and y coordinates can be taken from the spot the are on
    public piece(Boolean isWhite){
       white = isWhite; 
    }

    public Boolean isValid(int fromX, int fromY, int toY, int toX){
        return !(toX-fromX == 0 & toY-fromY == 0);
    }
}
