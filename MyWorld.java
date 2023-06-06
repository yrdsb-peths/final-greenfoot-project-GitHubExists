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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1);
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
}
