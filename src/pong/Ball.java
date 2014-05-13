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
        yVel = Math.random()*3;
    }
    public void move(Player right, Player left){
        System.out.println(xLoc + "," + yLoc);
        xLoc+=xVel;
        yLoc +=yVel;
        
        if(yLoc<0){
            yLoc = Math.abs(yLoc);
            yVel = -yVel;
            System.out.println("Y has bounced");
        }
        if(yLoc>500){
            yLoc = 500-(yLoc-500);
            yVel = -yVel;
            System.out.println("Y has bounced");
        }
        if(xLoc<15 && Math.abs(yLoc-right.getY())<50){
            xLoc=10+(10-xLoc);
            xVel=-xVel;
            System.out.println("x has bounced");
        }
        if(xLoc>475 && Math.abs(yLoc-left.getY())<50){
            xLoc=10+(10-xLoc);
            xVel=-xVel;
            System.out.println("x has bounced");
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
