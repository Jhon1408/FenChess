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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jhonatan
 */
public class Queen extends Pieces {
    public Queen(Game game, Board board, String type, int x, int y) {
        this.game = game;
        this.board = board;
        this.piecesTable = board.table;
        this.setSize(50,50);
        this.type = type;
        if("q".equals(this.type)) {
            this.sprite = new ImageIcon(new ImageIcon("Images/b_queen.png").getImage().getScaledInstance(sizeX/9, sizeY/9, Image.SCALE_DEFAULT));
        } else {
            this.sprite = new ImageIcon(new ImageIcon("Images/w_queen.png").getImage().getScaledInstance(sizeX/9, sizeY/9, Image.SCALE_DEFAULT));
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
            }
            
            @Override
            public void mouseReleased(MouseEvent me) {
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
        this.piecesTable[this.y][this.x] = " ";
        this.x = x;
        this.y = y;
        this.piecesTable[y][x] = this.type;
        this.draw(this.game);
        this.game.updateTable(board,piecesTable);
    }
}
