import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Smoke for when boss is at low hp
 * 
 * @author Stanley
 * @version June 2023
 */
public class Smoke extends Actor
{
    GreenfootImage smoke = new GreenfootImage("images/Smoke.png");
    int movementCounter = 9;
    /**
     * Act - do whatever the Smoke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Smoke()
    {
        setImage(smoke);
        smoke.scale(50,50);        
    }
    public void act()
    {
        setLocation(getX()-15,getY()-15);
        movementCounter -= 1;
        if (movementCounter == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
