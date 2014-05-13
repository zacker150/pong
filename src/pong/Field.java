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
public class Field extends JComponent implements Runnable{

    private Player p1;
    private Player p2;
    private Ball b;
    private boolean[][] moving;

    public Field(int width, int hight) {
        this.setBounds(20, 20, width, hight);
        p1 = new Player(10, hight / 2);
        p2 = new Player(width - 20, hight / 2);
        b = new Ball(width/2,hight/2);
        moving = new boolean[2][2];
        this.addKeyListener(new Control());
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Rectangle(0, 0, this.getWidth() - 1, this.getHeight() - 1));
        p1.draw(g2);
        p2.draw(g2);
        b.draw(g2);
    }
    public void run(){
        System.out.println("Running");
        while(true){
            b.move(p1, p2);
            if(moving[0][0]){
                p1.move(-1);
                System.out.println("Moving p1 down!");
            }
                
            if(moving[0][1]){
                p1.move(1);
                System.out.println("Moving p1 up!");
            }
            if(moving[1][0]){
                p2.move(-1);
                System.out.println("Moving p2 down!");
            }
            if(moving[1][1]){
                p2.move(1);
                System.out.println("Moving p2 up!");
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class Control implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_W){
                moving[1][0]= true;
            }
            else if(e.getKeyChar()==KeyEvent.VK_S){
                moving[1][1] = true;
            }
            if(e.getKeyCode()==KeyEvent.VK_UP){
                moving[1][0]= true;
            }
            else if(e.getKeyChar()==KeyEvent.VK_DOWN){
                moving[1][1] = true;
            }
                
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()=='w'){
                moving[1][0]= false;
            }
            else if(e.getKeyChar()=='s'){
                moving[1][1] = false;
            }
            if(e.getKeyCode()==KeyEvent.VK_UP){
                moving[1][0]= false;
            }
            else if(e.getKeyChar()==KeyEvent.VK_DOWN){
                moving[1][1] = false;
            }
        }
    }
}
