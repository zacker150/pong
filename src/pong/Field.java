/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.JComponent;
import java.awt.*;

/**
 *
 * @author 542331
 */
public class Field extends JComponent{
    private Player p1;
    private Player p2;
    private Ball b;
    
    public Field(int len, int wid){
        this.setSize(len, wid);
        p1 = new Player(10,wid/2);
        p2 = new Player(len-40,wid/2);
                
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Rectangle(0,0,this.getWidth()-1,this.getHeight()-1));
        p1.draw(g2);
        p2.draw(g2);
    }
}
