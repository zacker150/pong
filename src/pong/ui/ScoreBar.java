/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author 542331
 */
public class ScoreBar extends JComponent{
    int score1; //score of player 1
    int score2; // score of player 2
    /**
     *Creates a new ScoreBar with both players scores as 0
     */
    public ScoreBar(){
        score1=0;
        score2=0;
    }
    /**
     * Draws the ScoreBar on the JFrame
     * @param g 
     */
    public void paintComponent(Graphics g) {
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1); // draws a border
        String s = "Player 1: " + score1 + "                  Player 2: " + score2; 
        g.drawString(s,25,getHeight()-4);
    }
    /**
     * Increments the score of player1 and redraws the scoreboard
     */
    public void increment1(){
        score1++;
        repaint();
    }
    /**
     * Increments the score of player1 and redraws the scoreboard
     */
    public void increment2(){
        score2++;
        repaint();
    }
    /**
     * @return JButton that has a ResetListener for this object attached. 
     */
    public JButton getReset(){
        JButton reset = new JButton("Reset score");
        reset.addActionListener(new ResetListener());
        return reset;
    }
    /**
     * @return A listener that resets the score.
     */
    class ResetListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            score1=0;
            score2=0;
            repaint();
        }
    }
    
}
