import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game world after you hit start
 * 
 * @author Stanley
 * @version May 2023
 */
public class MyWorld extends World
{
    public int score = 10000;
    Label scoreLabel;
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
        
        Boss.bossHP = 300;
        Boss.bossCollisionDamage = true;
        Boss boss = new Boss();
        addObject(boss, 300, 0);
        
        Turret bossTurret = new Turret();
        addObject(bossTurret, 200, 0);
        
        for (int i = 0; i < 5; i++)
        {
            Health health = new Health(i);
            addObject(health, 35, 750-i*50);
        }
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel,100,50);
        scoreLabel.setValue(score);
        
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
    
    public void createSmoke(int x, int y)
    {
        Smoke smoke = new Smoke();
        addObject(smoke, x, y);
    }
    
    public void updateScore()
    {
        if (score > 0)
        {
            score --;
        }
        scoreLabel.setValue(score);
    }
}
