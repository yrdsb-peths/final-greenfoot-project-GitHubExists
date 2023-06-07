import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crosshair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crosshair extends Actor
{
    GreenfootImage crosshair = new GreenfootImage("images/Crosshair.png");
    /**
     * Act - do whatever the Crosshair wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int size = 145;
    double rotation = 20;
    public Crosshair()
    {
        setImage(crosshair);
        crosshair.scale(size,size);
        setRotation(Greenfoot.getRandomNumber(360));
    }
    public void act()
    {
        crosshair.scale(size,size);
        setRotation(getRotation()+(int)rotation);
        rotation -= 0.5;
        size = size-(size-140)/4;
        if (rotation == 0)
        {
            MyWorld world = (MyWorld) getWorld();
            world.makeExplosion(getX(), getY());
            getWorld().removeObject(this);
        }
    }
}
