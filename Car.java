import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player character
 * 
 * @author Stanley
 * @version June 2023
 */
public class Car extends Actor
{
    static int carX;
    static int carY;
    static int carHp;
    
    double xVel = 0;
    double yVel = 0;
    int shotInterval = 0;
    boolean start = true;
    
    static int invinciFrames = 0;
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (start)
        {
            carHp = 5;
            if (getY() < 600) {
                start = false;
            }
            shotInterval = 2;
            setLocation(300, getY()-8);
        }
        
        //Car moves depending on velocity
        carX = getX() + (int)(xVel+0.5);
        carY = getY() + (int)(yVel+0.5);
        shotInterval -= 1;
        setLocation(carX, carY);
        setRotation((int)(xVel+0.5)*2);
        
        control();
        
        hpCheck();
    }
    
    private void control()
    {
        // Changes velocity with which key is pressed
        if (Greenfoot.isKeyDown("left"))
        {
            xVel -= 0.5;
            if (xVel < -6)
            {
                xVel = -6;
            }
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            xVel += 0.5;
            if (xVel > 6)
            {
                xVel = 6;
            }
        }
        if (Greenfoot.isKeyDown("up"))
        {
            yVel -= 0.5;
            if (yVel < -6)
            {
                yVel = -6;
            }
        }
        else if (Greenfoot.isKeyDown("down"))
        {
            yVel += 0.5;
            if (yVel > 6)
            {
                yVel = 6;
            }
        } else
        {
            yVel *= 0.95;
        }
        if (Greenfoot.isKeyDown("space"))
        {
            if (shotInterval < 1) {
                MyWorld world = (MyWorld) getWorld();
                world.shoot(getX(), getY());
                shotInterval = 10;
            }
            
        }
    }
    
    public static void takeDamage()
    {
        if (Car.invinciFrames == 0)
        {
            invinciFrames = 75;
            carHp -= 1;
        }
        
    }
    private void hpCheck()
    {
        if (invinciFrames > 0)
        {
            invinciFrames -= 1;
        } 

        if (carHp == 0)
        {
            MyWorld world = (MyWorld) getWorld();
            world.makeExplosion(getX(), getY(), 150, false);
            getWorld().removeObject(this);
        }
    }
}
