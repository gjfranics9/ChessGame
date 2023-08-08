package board;

import main.GamePanel;

import java.awt.*;

public class TileManager {

    GamePanel gp;
    public Tile[][] board;

    public TileManager(GamePanel gp){
        this.gp=gp;
        board = new Tile[9][9];
        loadBoard();
    }

    public void loadBoard(){
        Color color;
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                if((i+j)%2 == 0){
                    color = new Color(0xF0D9B5);
                }
                else{
                    color = new Color(0x55342b);
                }
                board[i][j] = new Tile(new Rectangle(i*gp.tileSize, j*gp.tileSize, gp.tileSize,gp.tileSize),color);
            }
        }
    }
    public void draw(Graphics2D g2){
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                g2.setColor(board[i][j].color);
                g2.fill(board[i][j].square);
            }
        }
    }
}
