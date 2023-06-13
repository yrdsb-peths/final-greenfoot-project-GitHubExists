import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boss turret, indipendent asset from boss for animation purposes
 * 
 * @author Stanley
 * @version June 2023
 */
public class Turret extends Actor
{
    /**
     * Act - do whatever the Turret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = Boss.bossX;
        int y = Boss.bossY;
        int r = Boss.turretDirect;
        setRotation(r);
        if (r == 90)
        {
            y -= 90 + Boss.recoil;
        }
        else if (r == 270)
        {
            y += 90 - Boss.recoil;
        }
        else if (r == 0)
        {
            x += 90 - Boss.recoil;
        }
        else
        {
            x -= 90 + Boss.recoil;
        }
        if (Boss.recoil > 0)
        {
            Boss.recoil -= 1;
        }
        setLocation(x,y);
    }
}
