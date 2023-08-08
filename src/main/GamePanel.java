package main;

import entity.Piece;
import entity.PieceManager;
import board.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS

    public final int FPS = 45;
    public int originalTileSize = 16;
    public int scale = 6;
    public final int tileSize = originalTileSize*scale;
    public final int maxFiles = 8;
    public final int maxRanks = 8;
    public final int screenWidth = maxFiles*tileSize;
    public final int screenHeight = maxRanks*tileSize;
    public TileManager tileM = new TileManager(this);
    public ClickHandler clickH = new ClickHandler(this);
    public PieceManager pieceH = new PieceManager(this);

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        //this.addKeyListener(keyH);
        this.setFocusable(true);
        tileM = new TileManager(this);
        pieceH = new PieceManager(this);

        // Then initialize ClickHandler with the correct references
        clickH = new ClickHandler(this);

        addMouseListener(clickH);
        addMouseMotionListener(clickH);
    }


        
    public void startGameThread(){

        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }
            if(timer >= 1000000000){
                //System.out.println("FPS:" + drawCount);
                timer = 0;

            }
        }
    }

    public void update(){
        pieceH.update();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Piece piece = new Piece(this, "whitePawn", 5, 5);

        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        pieceH.drawAllPieces(g2);
        g2.dispose();
    }
}