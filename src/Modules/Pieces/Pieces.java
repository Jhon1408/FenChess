/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Pieces;

import Graphics.Game;
import Modules.Board;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jhonatan
 */
public class Pieces extends JLabel {
    String[][] piecesTable;
    List<Object> nextMoves = new ArrayList<>();
    int sizeX = 400;
    int sizeY = 400;
    public Game game;
    public Board board;
    int x;
    int y;
    public ImageIcon sprite;
    public String type;
    public String key;
    
    int getRange(int pos) {
        int value = (sizeX/8);
        int result = 0;
        if(pos < value) {
            result = 0;
        }
        if(pos > value+1 && pos < 2*value) {
            result = 1;
        }
        if(pos > (2*value)+1 && pos < 3*value) {
            result = 2;
        }
        if(pos > (3*value)+1 && pos < 4*value) {
            result = 3;
        }
        if(pos > (4*value)+1 && pos < 5*value) {
            result = 4;
        }
        if(pos > (5*value)+1 && pos < 6*value) {
            result = 5;
        }
        if(pos > (6*value)+1 && pos < 7*value) {
            result = 6;
        }
        if(pos > (7*value)+1 && pos < 8*value) {
            result = 7;
        }
        /*
        NavigableMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(0, 0);
        map.put((sizeX/8), 1);
        map.put(2 * (sizeX/8) , 2);
        map.put(3 * (sizeX/8), 3);
        map.put(4 * (sizeX/8), 4);
        map.put(5 * (sizeX/8), 5);
        map.put(6 * (sizeX/8), 6);
        map.put(7 * (sizeX/8), 7);
        return map.ceilingEntry(pos).getValue();
        */
        return result;
    }
    
    public String[][] getPiecesPosition() {
        return this.piecesTable;
    }
    
    public void fillBoard(Board board) {
        this.piecesTable = board.table;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                switch(board.table[i][j]) {
                    case "p":
                        Pawn b_pawn = new Pawn(game,board,"p",j,i);
                        b_pawn.draw(game);                       
                    break;
                    case "P":
                        Pawn w_pawn = new Pawn(game,board,"P",j,i);
                        w_pawn.draw(game);
                    break;
                    case "n":
                        Knight b_knight = new Knight(game,board,"n",j,i);
                        b_knight.draw(game);
                    break;
                    case "N":
                        Knight w_knight = new Knight(game,board,"N",j,i);
                        w_knight.draw(game);
                    break;
                    case "b":
                        Bishop b_bishop = new Bishop(game,board,"b",j,i);
                        b_bishop.draw(game);
                    break;
                    case "B":
                        Bishop w_bishop = new Bishop(game,board,"B",j,i);
                        w_bishop.draw(game);
                    break;
                    case "r":
                        Rook b_rook = new Rook(game,board,"r",j,i);
                        b_rook.draw(game);
                    break;
                    case "R":
                        Rook w_rook = new Rook(game,board,"R",j,i);
                        w_rook.draw(game);
                    break;
                    case "q":
                        Queen b_queen = new Queen(game,board,"q",j,i);
                        b_queen.draw(game);
                    break;
                    case "Q":
                        Queen w_queen = new Queen(game,board,"Q",j,i);
                        w_queen.draw(game);
                    break;
                    case "k":
                        King b_king = new King(game,board,"k",j,i);
                        b_king.draw(game);
                    break;
                    case "K":
                        King w_king = new King(game,board,"K",j,i);
                        w_king.draw(game);
                    break;
                    default:
                        
                    break;
                }
            }
        }
        game.setVisible(true);
    }
}
