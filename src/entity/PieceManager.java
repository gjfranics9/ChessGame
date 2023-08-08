package entity;

import board.TileManager;
import main.ClickHandler;
import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class PieceManager {

    GamePanel gp;
    ClickHandler clickH;
    TileManager tileM;

    public ArrayList<Piece> pieces;
    public PieceManager(GamePanel gp){

        this.gp = gp;
        this.clickH = gp.clickH;
        this.tileM = gp.tileM;
        pieces = new ArrayList<Piece>();
        setDefaultBoardPieces();

    }

    public void setDefaultBoardPieces(){

        pieces.add(new Piece(gp,"whiteRook",0 ,0 ));
        pieces.add(new Piece(gp,"whiteKnight",0 ,1 ));
        pieces.add(new Piece(gp,"whiteBishop",0 ,2 ));
        pieces.add(new Piece(gp,"whiteQueen",0 ,3 ));
        pieces.add(new Piece(gp, "whiteKing",0 ,4 ));
        pieces.add(new Piece(gp, "whiteBishop",0 ,5 ));
        pieces.add(new Piece(gp, "whiteKnight",0 ,6 ));
        pieces.add(new Piece(gp, "whiteRook",0 ,7 ));
        pieces.add(new Piece(gp, "whitePawn",1 ,0 ));
        pieces.add(new Piece(gp, "whitePawn",1 ,1 ));
        pieces.add(new Piece(gp, "whitePawn",1 ,2 ));
        pieces.add(new Piece(gp, "whitePawn",1 ,3 ));
        pieces.add(new Piece(gp,"whitePawn",1 ,4 ));
        pieces.add(new Piece(gp, "whitePawn",1 ,5 ));
        pieces.add(new Piece(gp, "whitePawn",1 ,6 ));
        pieces.add(new Piece(gp, "whitePawn",1 ,7 ));

        pieces.add(new Piece(gp, "blackRook",7 ,0 ));
        pieces.add(new Piece(gp, "blackKnight",7 ,1 ));
        pieces.add(new Piece(gp, "blackBishop",7 ,2 ));
        pieces.add(new Piece(gp, "blackQueen",7,3 ));
        pieces.add(new Piece(gp, "blackKing",7,4 ));
        pieces.add(new Piece(gp, "blackBishop",7,5 ));
        pieces.add(new Piece(gp, "blackKnight",7,6 ));
        pieces.add(new Piece(gp, "blackRook",7,7 ));
        pieces.add(new Piece(gp, "blackPawn",6,0 ));
        pieces.add(new Piece(gp, "blackPawn",6,1 ));
        pieces.add(new Piece(gp, "blackPawn",6,2 ));
        pieces.add(new Piece(gp, "blackPawn",6,3 ));
        pieces.add(new Piece(gp, "blackPawn",6,4 ));
        pieces.add(new Piece(gp, "blackPawn",6,5 ));
        pieces.add(new Piece(gp, "blackPawn",6,6 ));
        pieces.add(new Piece(gp, "blackPawn",6,7 ));
    }

    public void update(){
        for(Piece currentPiece : pieces){
            currentPiece.update();
        }
    }

    public void drawAllPieces(Graphics2D g2){
        for (Piece currentPiece : pieces) {
            currentPiece.draw(g2);
        }
    }
}
