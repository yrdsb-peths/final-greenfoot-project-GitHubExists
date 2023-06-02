import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author Stanley
 * @version June 2023
 */
public class Car extends Actor
{
    double xVel = 0;
    double yVel = 0;
    
    boolean start = true;
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (start)
        {
            if (getY() < 600) {
                start = false;
            }
            setLocation(300, getY()-8);
        }
        //Car moves depending on velocity
        int x = getX() + (int)(xVel+0.5);
        int y = getY() + (int)(yVel+0.5);
        setLocation(x, y);
        
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
    }
}
