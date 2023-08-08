package main;

import board.Tile;
import board.TileManager;
import entity.Piece;
import entity.PieceManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ClickHandler implements MouseListener, MouseMotionListener {

    private final GamePanel gp;
    private final TileManager tileM;

    private Tile selectedSquare;
    private int initialMouseX;
    private int initialMouseY;
    private int initialSquareX;
    private int initialSquareY;
    int mouseX;
    int mouseY;

    public ClickHandler(GamePanel gp) {
        this.gp = gp;
        this.tileM = gp.tileM;
    }

    public int getXPos() {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        return (int) b.getX();
    }

    public int getYPos() {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        return (int) b.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Not used in "click and drag" behavior
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //receives coordinates of the mouse on the screen
        int mouseX = e.getX();
        int mouseY = e.getY();
        // Iterate through the board to check if any square is clicked
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile currentSquare = tileM.board[i][j];
                if (currentSquare.square.contains(mouseX, mouseY)) {
                    selectedSquare = currentSquare;
                    initialMouseX = mouseX;
                    initialMouseY = mouseY;
                    initialSquareX = currentSquare.square.x;
                    initialSquareY = currentSquare.square.y;
                    break;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if (selectedSquare != null) {
            // Store the selected piece before resetting selectedSquare to null
            // The dragging operation is done, reset the selected square

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Tile newSquare = tileM.board[i][j];
                    //finds the location of the new square
                    if (newSquare.square.contains(mouseX, mouseY) && newSquare != selectedSquare && selectedSquare.containedPiece !=null) {
                            newSquare.containedPiece = selectedSquare.containedPiece;
                            newSquare.containedPiece.xPos = newSquare.square.x;
                            newSquare.containedPiece.yPos = gp.screenHeight - newSquare.square.y - gp.tileSize;
                            selectedSquare.containedPiece = null;
                            break;
                    }
                }
            }
            selectedSquare = null;
            gp.repaint();
        }
    }



    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectedSquare != null) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            // Calculate the offset from the original position of the square when it was clicked
            int offsetX = mouseX - initialMouseX;
            int offsetY = mouseY - initialMouseY;

            // Update the new position of the piece (contained in the selected square)
            if (selectedSquare.containedPiece != null) {
                selectedSquare.containedPiece.xPos = initialSquareX + offsetX;
                selectedSquare.containedPiece.yPos = initialSquareY + offsetY;

                // Flip the calculation to adjust the yPos correctly
                selectedSquare.containedPiece.yPos = gp.screenHeight - selectedSquare.containedPiece.yPos - gp.tileSize;

                gp.repaint();
            }
        }
    }



    // Other methods from MouseListener and MouseMotionListener interfaces
    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}
