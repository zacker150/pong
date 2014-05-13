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
    Player p1;
    Player p2;
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Wingdings",Font.BOLD,25));
        g2.drawString("Hello", 25, 25);
    }
}
