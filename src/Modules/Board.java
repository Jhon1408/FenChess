/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

/**
 *
 * @author Jhonatan
 */
public class Board {
    public String table[][] = new String[8][8];
    public State boardState = new State();
    public void fillBoard() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                table[i][j] = " ";
            }
        }
    }
    
    public String getBoardFEN() {
        String FEN = new String();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                FEN = FEN.concat(table[i][j]);
            }
        }
        return FEN;
    }
}
