/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.*;

/**
 *
 * @author 542331
 */
public class Ball {
    private double xLoc; //x cordinate of center
    private double yLoc; //y cordinate of center
    private double xVel; //velocity in the x direction
    private double yVel;// velocity in the y direction
    
    public Ball(int xl, int yl){
        xLoc = xl;
        yLoc = yl;
        xVel = Math.random()*6;
        yVel = Math.random()*3;
    }
    public void move(Player right, Player left){
        xLoc+=xVel;
        yLoc +=yVel;
        
        if(yLoc<0){
            yLoc = Math.abs(yLoc);
            yVel = -yVel;
        }
        if(yLoc>500){
            yLoc = 500-(yLoc-500);
            yVel = -yVel;
        }
        if(xLoc<=20 && xLoc>12 && Math.abs(yLoc-right.getY())<50){
            xLoc=15+(15-xLoc);
            xVel=-xVel;
        }
        if(xLoc>=475 && xLoc<478 && Math.abs(yLoc-left.getY())<50){
            xLoc=475-(xLoc-475);
            xVel=-xVel;
        }
    }
    public void draw(Graphics2D g){
        g.fillOval((int)xLoc-5, (int)yLoc-5, 10, 10);
    }
    public int getX(){
        return (int)xLoc;
    }
    public int getY(){
        return (int)yLoc;
    }
    
}
