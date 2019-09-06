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
public class Message {
    public void sendMessage(Object Message) {
        System.out.print("-------------------------------------------------------------------------\n");
        System.out.print(Message+"\n");
        System.out.print("-------------------------------------------------------------------------\n");
    }
    
    public void sendMessage(Object Message, String type) {
        System.out.print("-------------------------------------------------------------------------\n");
        System.out.print(type+": ");
        System.out.print(Message.toString()+"\n");
        System.out.print("-------------------------------------------------------------------------\n");
    }
}
