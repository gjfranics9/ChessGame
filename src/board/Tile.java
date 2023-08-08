package board;

import entity.Piece;

import java.awt.*;

public class Tile {
    public Rectangle square;
    Color color;
    public Piece containedPiece;

    public Tile(Rectangle square, Color color) {
        this.square = square;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
