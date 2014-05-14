/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.*;
import javax.swing.JComponent;

/**
 *
 * @author 542331
 */
public class ScoreBar extends JComponent{
    int score1;
    int score2;
    public ScoreBar(){
        score1=0;
        score2=0;
    }
    public void paintComponent(Graphics g) {
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
        String s = "Player 1: " + score1 + "                  Player 2: " + score2;
        g.drawString(s,25,getHeight()-4);
    }
    /*
     * Increments the score of player1 and redraws the scoreboard
     */
    public void increment1(){
        score1++;
        repaint();
    }
    /*
     * Increments the score of player1 and redraws the scoreboard
     */
    public void increment2(){
        score2++;
        repaint();
    }
    
}
