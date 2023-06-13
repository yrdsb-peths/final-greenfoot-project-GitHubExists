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
     * Act - do whatever the LaneSplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
