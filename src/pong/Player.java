
package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author 542331
 */
public class Player {
    private int xloc; //x coordinate of center
    private int yloc; //y coordinate of center
    private Color c;
    public static final int LENGTH = 100;
    public static final int WIDTH = 10;
    /**
     *
     * @param x The x coordinate of the center
     * @param y The y coordinate of the center.
     */
    public Player(int x, int y){
        this.xloc = x;
        this.yloc = y;
        //sets a random color 
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        c = new Color(r,g,b);
    }
    /**
     * Draws the player. 
     * @param g The graphics object to draw it on.
     */
    public void draw(Graphics2D g){
        Rectangle r = new Rectangle(xloc,yloc-50,WIDTH,LENGTH);
        Color old = g.getColor();
        //fills the inside
        g.setColor(c);
        g.fill(r);
        //draws a black border
        g.setColor(old);
        g.draw(r);
    }
    /**
     * @return The x coordinate of the center
     */
    public int getX(){
        return xloc;
    }
    /**
     * @return The Y coordinate of the center
     */
    public int getY(){
        return yloc;
    }
    /**
     * Moves the paddle up or down, unless its colliding with the border (
     * negative for down and positive for up)
     * @param y The number of pixels up or down.
     */
    public void move(int y){
        yloc+= y;
        if(yloc<50) // touching the top
            yloc = 50;
        if(yloc>450)//touching the bottom 
            yloc = 450;
    }
}
