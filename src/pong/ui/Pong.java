package pong.ui;


import pong.ui.Field;
import pong.ui.ScoreBar;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        d.setTitle("Pong v2.0 by Victor Zeng");
        d.setAlwaysOnTop(true);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    public Pong(){
        this.setLayout(null); //allows me to place compoents anywhere
        this.setSize(550, 600);
        //creates the field
        Field f = new Field(10,30);
        add(f);
        //creates the scorebar;
        ScoreBar bar = f.getScoreBar();
        bar.setBounds(10, 2, 300, 20);
        add(bar);
        //adds reset button
        JButton reset = bar.getReset();
        reset.setBounds(320,2,190,20);
        add(reset);
        //adds pause button
        JButton pause = new JButton("Pause");
        pause.setBounds(10,535,500,20);
        pause.addActionListener(new Pause(pause,f));
        add(pause);
        //shows the frame now that it's set up. 
        setVisible(true);
        //Pauses the game and dispays the instructions.
        f.pause();
        int x = JOptionPane.showConfirmDialog(this, "Controls:\nW: Move player 1 up\nS:Move player 1 down\nUp:Move player 2 up\nDown:Move player 2 down");
        f.pause(); //unpause
        //starts the main loop of the game.
        Thread t = new Thread(f); 
        t.start();
        System.out.println("starting");
        
    }
}
class Pause implements ActionListener{
        
        JButton button;
        Field f;//The field this controls
        
        public Pause(JButton b, Field f){
            button = b;
            this.f = f;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            f.pause();
            //changes the text of the button.
            if(f.paused())
                button.setText("Unpause");
            else
                button.setText("Pause");
        }
    }


