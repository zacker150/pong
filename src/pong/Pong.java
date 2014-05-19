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
        d.setTitle("Pong v1.1 by Victor Zeng");
        d.setAlwaysOnTop(true);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    public Pong(){
        this.setLayout(null);
        this.setSize(600, 600);
        Field f = new Field(10,30);
        //creates the scorebar;
        ScoreBar bar = f.getScoreBar();
        bar.setBounds(10, 2, 400, 20);
        add(f);
        add(bar);
        //adds reset button
        
        setVisible(true);
        Thread t = new Thread(f);
        t.start();
        System.out.println("starting");
    }
}


