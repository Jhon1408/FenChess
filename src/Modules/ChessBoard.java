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

public class ChessBoard {
    public Board Board;
    public Message Print = new Message();
    Translate Convert = new Translate();
    public void ChessBoard() {
        
    }
    
    public void loadTable() {
        Board = new Board();      
        String initialState = "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1";
        String Formatted = Convert.formatFEN(initialState);
        Board = Convert.insertTable(Board, Formatted);
        printBoard(Board);
        printState(Board);
    }
    
    public void printBoard(Board Board) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print("["+Board.table[i][j]+"]");
            }
            System.out.print("\n");  
        }
    }
    
    private void printState(Board Board) {
        Print.sendMessage(Board.boardState.getState(), "STATE");
        Print.sendMessage(Convert.formatBoard(Board), "FEN");
    }
}
