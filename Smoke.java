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
     * Smoke moves out from the Boss as an indicator to the Player that it is at low HP
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
