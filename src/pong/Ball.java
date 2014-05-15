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
        xVel = Math.random()*3;
        if(Math.abs(xVel)<2){
            if(xVel>0)
                xVel+=2;
            if(xVel<0)
                xVel-=2;
        }
        yVel = Math.random()*3;
    }
    public void move(Player right, Player left){
        xLoc+=xVel;
        yLoc +=yVel;
        //bounces off the top of the playing field
        if(yLoc<5){
            yLoc = 5+(5-yLoc);
            yVel = -yVel;
        }
        //bounces off the bottom of the playing field
        if(yLoc>495){
            yLoc = 495-(yLoc-495);
            yVel = -yVel;
        }
        //bounces off the right Paddle
        if(xLoc<=20 && xLoc>12 && Math.abs(yLoc-right.getY())<50){
            xLoc=20+(20-xLoc);
            if(xLoc<20)
                xLoc = 20;
            xVel=-xVel;
        }
        //bounces off the left Paddle
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
