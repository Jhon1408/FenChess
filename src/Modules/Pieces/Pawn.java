/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Pieces;

import Graphics.Game;
import Modules.Board;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jhonatan
 */
public class Pawn extends Pieces {
    public Pawn(Game game, Board board, String type, int x, int y) {
        this.game = game;
        this.board = board;
        this.piecesTable = board.table;
        this.setSize(50,50);
        this.type = type;
        if("p".equals(this.type)) {
            this.sprite = new ImageIcon(new ImageIcon("Images/b_pawn.png").getImage().getScaledInstance(sizeX/9, sizeY/9, Image.SCALE_DEFAULT));
        } else {
            this.sprite = new ImageIcon(new ImageIcon("Images/w_pawn.png").getImage().getScaledInstance(sizeX/9, sizeY/9, Image.SCALE_DEFAULT));
        }
        this.x = x;
        this.y = y;
        this.setIcon(this.sprite);
        
        addMouseListener(new MouseListener() {
            public boolean moving = false;
            @Override            
            public void mouseClicked(MouseEvent me) {
                
            }
            
            @Override
            public void mousePressed(MouseEvent me) {
                moving = true;
                showNextMoves();
            }
            
            @Override
            public void mouseReleased(MouseEvent me) {
                removeNextMoves();
                System.out.print("["+getRange(game.getMousePosition().x-5)+" "+getRange(game.getMousePosition().y-20)+"]");
                movePiece(getRange(game.getMousePosition().x-5),getRange(game.getMousePosition().y-20));
                moving = false;
            }
            
            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        });
        this.game.add(this, 0, 0);
    }
    
    public void draw(JFrame Game) {       
        this.setLocation((this.x * (sizeX/8)), ((this.y * sizeY/8)));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.repaint();
        this.setVisible(true);
    }
    
    public void movePiece(int x, int y) {
        List<Object> posibleMoves = getNextMove(this.x,this.y);
        boolean currentMoveAllowed = false;
        for(int i = 0; i < posibleMoves.size(); i++) {
            currentMoveAllowed = comprovarMovimiento(x,y,(int[]) posibleMoves.get(i));
            if(currentMoveAllowed) {
                break;
            }           
        }
        if(currentMoveAllowed) {            
            this.piecesTable[this.y][this.x] = " ";
            this.x = x;
            this.y = y;
            this.piecesTable[y][x] = this.type;
            this.draw(this.game);
            this.board.boardState.nextTurn();            
            if("P".equals(this.type) && this.y == 4) {
                this.board.boardState.enPassant(x, y+1);
            }
            if("p".equals(this.type) && this.y == 3) {
                this.board.boardState.enPassant(x, y-1);
            }
            this.game.updateTable(board,piecesTable);
        }
    }
    
    public List<Object> getNextMove(int x, int y) {
        List<Object> moves = new ArrayList<>();
        int[] point = new int[2];
        int[] point2 = new int[2];
        if(this.type.equals("P") && this.y != 0) {
            if(this.y == 6) {
                point[0] = x;
                point[1] = y-2;
                moves.add(point);
                point2[0] = x;
                point2[1] = y-1;
                moves.add(point2);
            } else {
                point[0] = x;
                point[1] = y-1;
                moves.add(point);
            }
        } else
        if(this.type.equals("p") && this.y != 7) {
            if(y == 1) {
                point[0] = x;
                point[1] = y+2;
                moves.add(point);
                point2[0] = x;
                point2[1] = y+1;
                moves.add(point2);
            } else {
                point[0] = x;
                point[1] = y+1;
                moves.add(point);
            }
        }
        return moves;
    }
    
    public boolean comprovarMovimiento(int x, int y, int[] temp) {
        boolean result = false;
        if(("b".equals(board.boardState.getTurn())) && (!this.type.equals(this.type.toUpperCase())) && (x == temp[0]) && (y == temp[1])) {          
            result = true;
        } else if("w".equals(board.boardState.getTurn()) && !this.type.equals(this.type.toLowerCase()) && (x == temp[0]) && (y == temp[1])) {
            result = true;
        }
        return result;
    }
    
    public void removeNextMoves() {
        for(int i = 0; i < this.nextMoves.size(); i++) {
            JLabel currentMove = (JLabel) this.nextMoves.get(i);          
            currentMove.setVisible(false);
            game.remove(currentMove);
        }
        this.nextMoves.clear();
    }
    
    public void showNextMoves() {
        List posibleMoves = getNextMove(this.x,this.y);
        int[] temp;
        for(int i = 0; i < posibleMoves.size(); i++) {
            temp = (int[]) posibleMoves.get(i);
            JLabel move = new JLabel();
            move.setSize(50,50);
            move.setIcon(new ImageIcon(new ImageIcon("Images/move.png").getImage().getScaledInstance(sizeX/9, sizeY/9, Image.SCALE_DEFAULT)));
            this.nextMoves.add(move);           
            move.setLocation((temp[0] * (sizeX/8)), ((temp[1] * sizeY/8)));
            move.setHorizontalAlignment(JLabel.CENTER);
            move.setVisible(true);
            game.add(move, 0, 0);
            game.repaint();
        }
    }
}
