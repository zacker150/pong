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
    public ScoreBar(int x, int y){
        setBounds(x,y,200,10);
        score1=0;
        score2=0;
    }
    public void paintComponent(Graphics g) {
        g.drawString("Player 1: " + score1 + "Player 2: " + score2,0,0);
    }
    public void increment1(){
        score1++;
    }
    public void increment2(){
        score2++;
    }
    
}
