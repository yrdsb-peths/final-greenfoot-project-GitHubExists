import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Stanley
 * @version May 2023
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 800 cells with a cell size of 1x1 pixels.
        super(600, 800, 1);
        
        Greenfoot.setSpeed(50);
        
        // Create car
        Car car = new Car();
        addObject(car, 300, 800);
        
        Boss boss = new Boss();
        addObject(boss, 300, 0);
        
        Turret bossTurret = new Turret();
        addObject(bossTurret, 200, 0);
    }
    
    public void shoot(int x, int y)
    {
        Shot shot = new Shot();
        addObject(shot, x, y-6);
    }
    
    public void telegraph(int x, int y)
    {
        Crosshair crosshair = new Crosshair();
        addObject(crosshair, x, y);
    }
    
    public void makeExplosion(int x, int y, int s, boolean d)
    {
        Explosion explosion = new Explosion(s,d);
        addObject(explosion, x, y);
    }
    
    public void makeLaneSplosion(int x, int y)
    {
        LaneSplosion laneSplosion = new LaneSplosion();
        addObject(laneSplosion, x, y);
    }
}
