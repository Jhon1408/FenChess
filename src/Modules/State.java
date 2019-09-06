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
public class State {
    public String turnOf;
    // Castling availability //
    public String K = "-";
    public String Q = "-";
    public String k = "-";
    public String q = "-";
    
    public String enPassant;
    
    public String HM;
    public String FM;
    
    public List getState() {
        List<Object> StateList = new ArrayList<>();
        StateList.add(turnOf);
        StateList.add(K);
        StateList.add(Q);
        StateList.add(k);
        StateList.add(q);
        StateList.add(enPassant);
        StateList.add(HM);
        StateList.add(FM);
        return StateList;
    }
    
    public String getTurn() {
        return this.turnOf;
    }
    
    public void nextTurn() {
        if("w".equals(this.turnOf)) {
            this.turnOf = "b";
        } else {
            this.turnOf = "w";
        }
    }
    
    public void enPassant(int x, int y) {
        String passant = new String();
        switch(x) {
            case 0:
                passant = passant.concat("a"+(y+1));
            break;
            case 1:
                passant = passant.concat("b"+(y+1));
            break;
            case 2:
                passant = passant.concat("c"+(y+1));
            break;
            case 3:
                passant = passant.concat("d"+(y+1));
            break;
            case 4:
                passant = passant.concat("e"+(y+1));
            break;
            case 5:
                passant = passant.concat("f"+(y+1));
            break;
            case 6:
                passant = passant.concat("g"+(y+1));
            break;
            case 7:
                passant = passant.concat("h"+(y+1));
            break;
        }
        this.enPassant = passant;
    }
    
    public void setState(List stateList) {       
        turnOf = stateList.get(0).toString();
        switch (stateList.size()) {
            case 5:
                switch(stateList.get(1).toString()) {
                    case "K":
                        K = stateList.get(1).toString();
                    break;
                    case "Q":
                        Q = stateList.get(1).toString();
                    break;
                    case "k":
                        k = stateList.get(1).toString();
                    break;
                    case "q":
                        q = stateList.get(1).toString();
                    break;                           
                }                
                enPassant = stateList.get(2).toString();
                HM = stateList.get(3).toString();
                FM = stateList.get(4).toString();                
            break;
            case 6:
                switch(stateList.get(1).toString()) {
                    case "K":
                        K = stateList.get(1).toString();
                    break;
                    case "Q":
                        Q = stateList.get(1).toString();
                    break;
                    case "k":
                        k = stateList.get(1).toString();
                    break;
                    case "q":
                        q = stateList.get(1).toString();
                    break;                           
                }
                switch(stateList.get(2).toString()) {
                    case "K":
                        K = stateList.get(2).toString();
                    break;
                    case "Q":
                        Q = stateList.get(2).toString();
                    break;
                    case "k":
                        k = stateList.get(2).toString();
                    break;
                    case "q":
                        q = stateList.get(2).toString();
                    break;
                }
                enPassant = stateList.get(3).toString();
                HM = stateList.get(4).toString();
                FM = stateList.get(5).toString(); 
            break;
            case 7:
                switch(stateList.get(1).toString()) {
                    case "K":
                        K = stateList.get(1).toString();
                    break;
                    case "Q":
                        Q = stateList.get(1).toString();
                    break;
                    case "k":
                        k = stateList.get(1).toString();
                    break;
                    case "q":
                        q = stateList.get(1).toString();
                    break;                           
                }
                switch(stateList.get(2).toString()) {
                    case "K":
                        K = stateList.get(2).toString();
                    break;
                    case "Q":
                        Q = stateList.get(2).toString();
                    break;
                    case "k":
                        k = stateList.get(2).toString();
                    break;
                    case "q":
                        q = stateList.get(2).toString();
                    break;
                }
                switch(stateList.get(3).toString()) {
                    case "K":
                        K = stateList.get(3).toString();
                    break;
                    case "Q":
                        Q = stateList.get(3).toString();
                    break;
                    case "k":
                        k = stateList.get(3).toString();
                    break;
                    case "q":
                        q = stateList.get(3).toString();
                    break;
                }
                enPassant = stateList.get(4).toString();
                HM = stateList.get(5).toString();
                FM = stateList.get(6).toString();
                break;
            default:
                K = stateList.get(1).toString();
                Q = stateList.get(2).toString();
                k = stateList.get(3).toString();
                q = stateList.get(4).toString();
                enPassant = stateList.get(5).toString();
                HM = stateList.get(6).toString();               
                FM = stateList.get(7).toString();
            break;
        }
    }
}
