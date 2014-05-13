package pong;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 542331
 */
public class Pong extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame d = new Pong();
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d.setVisible(true);
        
    }
    public Pong(){
        setSize(500,500);
        add(new Field(this.getWidth(),this.getHeight()));
    }
}


