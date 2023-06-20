import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game world after you hit start
 * 
 * @author Stanley
 * @version May 2023
 */
public class MyWorld extends World
{
    // Score works as a timer, the more time it takes to beat the boss, the less score is given
    public int score;
    Label scoreLabel;
    /**
     * Set up game world
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 800 cells with a cell size of 1x1 pixels.
        super(565, 800, 1);
        
        Greenfoot.setSpeed(50);
        
        // Create car
        Car car = new Car();
        addObject(car, 275, 800);
        
        // Create Boss
        Boss.bossHP = 300;
        Boss.bossCollisionDamage = true;
        Boss boss = new Boss();
        addObject(boss, 275, 0);
        // Create Boss Turret
        Turret bossTurret = new Turret();
        addObject(bossTurret, 275, 0);
        // Create Hearts to display health
        for (int i = 0; i < 5; i++)
        {
            Health health = new Health(i);
            addObject(health, 35, 750-i*50);
        }
        // Set up score
        score = 10000;
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel,100,50);
        scoreLabel.setValue(score);
        
    }
    
    // Shoot a bullet from Car when Space is pressed
    public void shoot(int x, int y)
    {
        Shot shot = new Shot();
        addObject(shot, x, y-6);
    }
    
    // Place a Crosshair to indicate place of attack
    public void telegraph(int x, int y)
    {
        Crosshair crosshair = new Crosshair();
        addObject(crosshair, x, y);
    }
    
    // Create an explosion, can be damaging or not
    public void makeExplosion(int x, int y, int s, boolean d)
    {
        Explosion explosion = new Explosion(s,d);
        addObject(explosion, x, y);
    }
    
    // Create LaneSplosion, an attack that sends explosions down a lane
    public void makeLaneSplosion(int x, int y)
    {
        LaneSplosion laneSplosion = new LaneSplosion();
        addObject(laneSplosion, x, y);
    }
    
    // Create smoke to indicate Boss has low HP
    public void createSmoke(int x, int y)
    {
        Smoke smoke = new Smoke();
        addObject(smoke, x, y);
    }
    
    // Decrease score as time passes
    public void updateScore()
    {
        if (score > 0)
        {
            score --;
        }
        scoreLabel.setValue(score);
    }
    
    // Decrease score when player gets hit
    public void decreaseScore()
    {
        if (score > 1000)
        {
            score -= 1000;
        }
        else
        {
            score = 0;
        }
    }
    
    // When player HP hits zero, produce game over
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over!", 70);
        addObject(gameOverLabel, 275, 400);
        scoreLabel.setValue("");
    }
    
    // When Boss HP hits zero, trigger victory
    public void victory()
    {
        Label victoryLabel = new Label("You Win!", 70);
        addObject(victoryLabel, 275, 350);
        Label finalScore = new Label("Final Score: " + score, 70);
        addObject(finalScore, 275, 425);
        scoreLabel.setValue("");
    }
}
