/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonatan
 */
public class Translate {
    /*
    Pawn   = "P"
    Knight = "N"
    Bishop = "B"
    Rook   = "R"
    Queen  = "Q"
    King   = "K"
    */
    
    public Board insertTable(Board Board, String FormattedFEN) {
        int temporal = 0;
        List<Object> State = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                Board.table[i][j] = Character.toString(FormattedFEN.charAt((i*8)+j));
                temporal = (i*8)+j;
            }           
        }
        for(int i = temporal+1; i < FormattedFEN.length(); i++) {
            if(Character.toString(FormattedFEN.charAt(i)).matches("[a-h]") && Character.toString(FormattedFEN.charAt(i+1)).matches("[1-8]")) {
                String add = Character.toString(FormattedFEN.charAt(i)) + Character.toString(FormattedFEN.charAt(i+1));
                State.add(add);
                i++;
            } else {
                if(Character.toString(FormattedFEN.charAt(i)).matches("[-]")) {
                    State.add("-");
                } else {
                    State.add(FormattedFEN.charAt(i));
                }               
            }    
        }
        Board.boardState.setState(State);
        return Board;
    }
    
    public String formatFEN(String FEN) {
        String FormattedFEN = new String();
        String temp;
        int tempI = 0;
        for(int i = 0; i < FEN.length(); i++) {
            temp = Character.toString(FEN.charAt(i));
            if(temp.matches("[A-Za-z-]")){
                FormattedFEN = FormattedFEN.concat(temp);
            } else if(temp.matches("[0-9]")) {
                for(int j = 0; j < Integer.parseInt(temp); j++) {
                    FormattedFEN = FormattedFEN.concat(" ");
                }
            }
            if(FormattedFEN.length() == 64) {
                tempI = i;
                break;
            }
        }
        for(int i = tempI+1; i < FEN.length(); i++) {
            temp = Character.toString(FEN.charAt(i));
            if(temp.matches("[A-Za-z0-9-]")){
                FormattedFEN = FormattedFEN.concat(temp);                      
            }
        }
        return FormattedFEN;
    }
    
    public String formatBoard(Board Board) {
        String FEN = new String();
        String formattedFEN = Board.getBoardFEN();
        formattedFEN = formattedFEN.concat(" ");
        int temp = 0;
        int cont = 1;
        for(int i = 0; i < formattedFEN.length()-1; i++) {
            if(Character.toString(formattedFEN.charAt(i)).matches("[ ]")) {
                temp = temp + 1;                                    
                if(temp > 0 && Character.toString(formattedFEN.charAt(i+1)).matches("[a-zA-Z]") || cont == 8) {
                    FEN = FEN.concat(Integer.toString(temp));
                    temp = 0;
                }
            } else {
               FEN = FEN.concat(Character.toString(formattedFEN.charAt(i)));
            }
            if(cont == 8) {
                FEN = FEN.concat("/");
                cont = 0;
            }
            cont++;
        }
        
        FEN = FEN.substring(0, FEN.length()-1);
        
        FEN = FEN.concat(" "+Board.boardState.getState().get(0));
        FEN = FEN.concat(" "+Board.boardState.getState().get(1));
        FEN = FEN.concat(""+Board.boardState.getState().get(2));
        FEN = FEN.concat(""+Board.boardState.getState().get(3));
        FEN = FEN.concat(""+Board.boardState.getState().get(4));
        FEN = FEN.concat(" "+Board.boardState.getState().get(5));
        FEN = FEN.concat(" "+Board.boardState.getState().get(6));
        FEN = FEN.concat(" "+Board.boardState.getState().get(7));
        
        return FEN;
    }
    
}
