package entity;

import board.Tile;
import board.TileManager;
import main.ClickHandler;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Piece extends Entity {

    GamePanel gp;
    ClickHandler clickH;
    TileManager tileM;
    String type;
    public int xPos;
    public int yPos;
    public boolean clicked;
    int rank;
    int file;


    public Piece(GamePanel gp,String type, int rank, int file) {

        this.gp = gp;
        this.clickH = gp.clickH;
        this.tileM = gp.tileM;
        this.type = type;
        this.rank = rank;
        this.file = file;

        getPlayerImage();
        setPiecePosition(rank, file);
        insertIntoSquare();
    }

    public void insertIntoSquare() {

        Tile square = tileM.board[file][7-rank];
        square.containedPiece = this;
    }

    public void getPlayerImage() {
        try {
            switch (type) {
                case "whitePawn" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/whitePawn.png")));
                }
                case "whiteBishop" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/whiteBishop.png")));
                }
                case "whiteKnight" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/whiteKnight.png")));
                }
                case "whiteRook" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/whiteRook.png")));
                }
                case "whiteQueen" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/whiteQueen.png")));
                }
                case "whiteKing" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/whiteKing.png")));
                }
                case "blackPawn" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/blackPawn.png")));
                }
                case "blackBishop" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/blackBishop.png")));
                }
                case "blackKnight" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/blackKnight.png")));
                }
                case "blackRook" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/blackRook.png")));
                }
                case "blackQueen" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/blackQueen.png")));
                }
                case "blackKing" -> {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pieces/blackKing.png")));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPiecePosition(int rank, int file) {
        xPos = file * gp.tileSize;
        yPos = rank * gp.tileSize;
    }

    public void update() {
        if (clicked) {
            int mouseX = clickH.getXPos();
            int mouseY = clickH.getYPos();

            // Calculate the offset from the original position of the piece when it was clicked
            int xOffset = mouseX - (file * gp.tileSize);
            int yOffset = mouseY - (rank * gp.tileSize);

            // Update the new position of the piece
            xPos = mouseX - xOffset;
            yPos = mouseY - yOffset;

            gp.repaint();
            System.out.println("Clicked piece");
        } else {
            return;
        }
    }

    public void draw(Graphics2D g2) {
        // Flip the yPos calculation
        g2.drawImage(image, xPos, gp.screenHeight - yPos - gp.tileSize, gp.tileSize, gp.tileSize, null);
        gp.repaint();
    }
}

