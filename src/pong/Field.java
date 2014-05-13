/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 542331
 */
public class Field extends JComponent {

    private Player p1;
    private Player p2;
    private Ball b;

    public Field(int width, int hight) {
        this.setBounds(20, 20, width, hight);
        p1 = new Player(10, hight / 2);
        p2 = new Player(width - 20, hight / 2);
        b = new Ball(width/2,hight/2);
        //this.add
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Rectangle(0, 0, this.getWidth() - 1, this.getHeight() - 1));
        p1.draw(g2);
        p2.draw(g2);
        b.draw(g2);
    }
    class control implements KeyListener{
        public void keyPressed(KeyEvent e){
            
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
