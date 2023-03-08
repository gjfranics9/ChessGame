package Classes;
/**
 * @author George Francis
 * @version 0.00
 */
/*
 * Notes for developer:
 * 
 * Super class for all pieces on the board (pieces also represents pawns in the code although contrary to chess terminology).
 * The class must be abstract as there can only be a specific type of piece and not a general 'piece' instance
 * 
 * Attr -> positions (x and y)
 * Attr -> colour
 * 
 * method -> attemptMove(newX coordinate, newY coordinate)
 * method -> isValidMove(newX coordinate, newY coordinate, X, Y) [current x and y part of object so parameters not needed] [Different for each piece but they all need it so make an abstract method]
 * method -> move(newX coordinate, newY coordinate) [dependent on isValidMove]
 * method -> isTakingPiece(newX coordinate, newY coordinate)
 * method -> takePiece(newX coordinate, newY coordinate) [dependent on isTakingPiece]
 * method -> getTaken()
 * method -> getPos()
 * method -> setPos(X coordinate, Y coordinate)
 * method -> getColour()
 * method -> setColour(either white or black)
 */
public abstract class piece {

    private int pieceX;
    private int pieceY;
    private int pieceColour;
    //colour should never be entered as anything other than a 1 or 0. Look for eventual fix to help with code strength
    public piece(int x, int y, int colour){
        pieceX = x;
        pieceY = y;
        pieceColour = colour;
    }

    public abstract boolean attemptMove(int newX, int newY);

    public void move(int newX, int newY){
        if(attemptMove(newX, newY) == true){
            pieceX = newX;
            pieceY = newY;
        }
        else{
            invalidMove();
        }
    }

    public void invalidMove(){
        System.out.println("Move is invalid");
    }
}
