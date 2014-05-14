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
    public void reset(){
        p1 = new Player(10, this.getHeight() / 2);
        p2 = new Player(this.getWidth() - 20, this.getHeight() / 2);
        b = new Ball(this.getWidth()/2,this.getHeight()/2);
        moving = new boolean[2][2];
    }
    /*
     * The main loop of the game.
     */
    public void run(){
        System.out.println("Running");
        System.out.println(this.requestFocus(false));
        while(true){
            b.move(p1, p2); //moves the ball
//            p1.move(b.getY()-p1.getY());
//            p2.move(b.getY()-p2.getY());
            if(moving[0][0]){
                p1.move(-5);//moves Player 1 up 5
            }                
            if(moving[0][1]){
                p1.move(5);//moves Player 1 down 5
            }
            if(moving[1][0]){
                p2.move(-5);//moves Player 2 up 5
            }
            if(moving[1][1]){
                p2.move(5);//moves Player 2 down 5
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(b.getX() <5){
                reset();
            }
            if(b.getX()>495){
                reset();
            }
        }
    }
    class Control implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_W){
                moving[0][0]= true;
            }
            else if(e.getKeyCode()==KeyEvent.VK_S){
                moving[0][1] = true;
            }
            if(e.getKeyCode()==KeyEvent.VK_UP){
                moving[1][0]= true;
            }
            else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                moving[1][1] = true;
            }
                
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_W){
                moving[0][0]= false;
            }
            else if(e.getKeyCode()==KeyEvent.VK_S){
                moving[0][1] = false;
            }
            if(e.getKeyCode()==KeyEvent.VK_UP){
                moving[1][0]= false;
            }
            else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                moving[1][1] = false;
            }
        }
    }
}
