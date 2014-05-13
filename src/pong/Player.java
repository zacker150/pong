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
    private int x; //x cordinate of top left corner
    private int y; //y cordinate of top left corner
    private Color c;
    
    public Player(int x, int y){
        this.x = x;
        this.y = y;
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        c = new Color(r,g,b);
    }
    public void draw(Graphics2D g){
        Rectangle r = new Rectangle(x,y-50,10,100);
        Color old = g.getColor();
        g.setColor(c);
        g.fill(r);
        g.setColor(old);
        g.draw(r);
    }
}
