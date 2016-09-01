/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.*;
import java.awt.geom.Ellipse2D;

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
        xVel = (Math.random()-.5)*3;
        if(Math.abs(xVel)<2){
            if(xVel>0)
                xVel+=2;
            if(xVel<0)
                xVel-=2;
        }
        yVel = Math.random()*3;
    }
    /**
     * Accelerates the ball by .1414 pixels per frame
     */
    public void accelerate(){
        double acceleration = .1;
        if(xVel<0)
            xVel-=acceleration;
        if(xVel>0)
            xVel+=acceleration;
        if(yVel<0)
            yVel-=acceleration;
        if(yVel>0)
            yVel+=acceleration;
        System.out.println(xVel + " " + yVel);
        
    }
    /**
     * Moves the ball, taking into account the bouncing. 
     * @param right the player on the right side of the field
     * @param left  the player on the left side of the field
     */
    public void move(Player right, Player left){
        xLoc+=xVel;
        yLoc +=yVel;
        
        //bounces off the top of the playing field
        if(yLoc<5){
            yLoc = 10-yLoc;
            yVel = -yVel;
        }
        //bounces off the bottom of the playing field
        if(yLoc>495){
            yLoc = 990-(yLoc);
            yVel = -yVel;
        }
        //bounces off the right Paddle
        if(xLoc<=right.getX()+Player.WIDTH/2 && xLoc>right.getX()-Player.WIDTH/2
                && Math.abs(yLoc-right.getY())<Player.LENGTH/2){
            xLoc=20+(20-xLoc);
            if(xLoc<20)
                xLoc = 20;
            xVel=-xVel;
            accelerate();
        }
        //bounces off the left Paddle
        if(xLoc>=left.getX()-Player.WIDTH/2 && xLoc<left.getX()+Player.WIDTH/2
                && Math.abs(yLoc-left.getY())<Player.LENGTH/2){
            xLoc=475-(xLoc-475);
            xVel=-xVel;
            accelerate();
        }
    }
    /**
     * Draws the ball
     * @param g The graphics object to draw it to
     */
    public void draw(Graphics2D g){
        Ellipse2D.Double ell = new Ellipse2D.Double(xLoc-5,yLoc-5,10,10);
        g.fill(ell);
    }
    /**
     * 
     * @return the x-coordinate of the center rounded to the nearest integer. 
     */
    public int getX(){
        return (int)xLoc;
    }
    /**
     * 
     * @return  the y-coordinate of the center rounded to the nearest integer.
     */
    public int getY(){
        return (int)yLoc;
    }
    
}
