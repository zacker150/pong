package pong;


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
        d.setTitle("Pong v1.2 by Victor Zeng");
        d.setAlwaysOnTop(true);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    public Pong(){
        this.setLayout(null);
        this.setSize(550, 600);
        Field f = new Field(10,30);
        //creates the scorebar;
        ScoreBar bar = f.getScoreBar();
        bar.setBounds(10, 2, 300, 20);
        add(f);
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
        setVisible(true);
        f.pause();
        int x = JOptionPane.showConfirmDialog(this, "Controls:\nW: Move player 1 up\nS:Move player 1 down\nUp:Move player 2 up\nDown:Move player 2 down");
        f.pause();
        Thread t = new Thread(f);
        t.start();
        System.out.println("starting");
        
    }
}
class Pause implements ActionListener{
        
        JButton button;
        Field f;
        
        public Pause(JButton b, Field f){
            button = b;
            this.f = f;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            f.pause();
            if(f.paused())
                button.setText("Unpause");
            else
                button.setText("Pause");
        }
    }


