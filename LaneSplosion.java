import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Boss's attacks, a chain explosion down the lane
 * 
 * @author Stanley
 * @version June 2023
 */
public class LaneSplosion extends Actor
{
    int interval = 0;
    /**
     * Move downward at a constant speed, creating an explosion as it goes
     */
    
    public void act()
    {
        if (interval == 0)
        {
            setLocation(getX(), getY()+50);
            interval = 8;
            MyWorld world = (MyWorld) getWorld();
            world.makeExplosion(getX(), getY(), 150, true);
        }
        interval -= 1;
        if (getY() > 780)
        {
            getWorld().removeObject(this);
        }
    }
}
