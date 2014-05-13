/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author 542331
 */
public class Player {
    private int xloc; //x cordinate of center
    private int yloc; //y cordinate of center
    private Color c;
    
    public Player(int x, int y){
        this.xloc = x;
        this.yloc = y;
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        c = new Color(r,g,b);
    }
    public void draw(Graphics2D g){
        Rectangle r = new Rectangle(xloc,yloc-50,10,100);
        Color old = g.getColor();
        g.setColor(c);
        g.fill(r);
        g.setColor(old);
        g.draw(r);
    }
    public int getX(){
        return xloc;
    }
    public int getY(){
        return yloc;
    }
    public void move(int y){
        yloc+= y;
    }
}
