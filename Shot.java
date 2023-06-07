import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot extends Actor
{
    GreenfootImage bullet = new GreenfootImage("images/Bullet.png");

    /**
     * Act - do whatever the Shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Shot()
    {
        setImage(bullet);
        bullet.scale(25,25);        
    }
    public void act()
    {
        
        setLocation(getX(), getY()-15);
        
        if (getY() == 0 || isTouching(Boss.class)) {
            getWorld().removeObject(this);
        }
    }
}
