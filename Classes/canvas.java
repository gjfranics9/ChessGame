package Classes;
/**
 * @author George Francis
 * @version 0.10
 */
import java.awt.*;
import javax.swing.*;

class canvas extends JComponent {
    private int width;
    private int height;
    private board Board;

    public canvas(int w, int h, board inputBoard){
        width = w;
        height = h;
        Board = inputBoard;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Board.drawBoard(g2d);
        }
}
