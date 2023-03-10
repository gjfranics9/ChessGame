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
    private spot[][] Board;

    public canvas(int w, int h, spot[][] board){
        width = w;
        height = h;
        Board = board;
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            for(int row=0; row<9; row++){
                for(int col=0; col<9; col++){
                    spot Square = Board[col][row];
                    if(col % 2 == 1 && row % 2 == 0){
                        Square.drawSelf(g2d);
                        }
                    else if(col % 2 == 0 && row % 2 == 1){
                        Square.drawSelf(g2d);
                        }
                    }
                }
            }
        }
