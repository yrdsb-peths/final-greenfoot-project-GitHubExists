import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * The player shot that damages the boss
 * 
 * @author Stanley
 * @version June 2023
 */
public class Shot extends Actor
{
    GreenfootImage bullet = new GreenfootImage("images/Bullet.png");

    /**
     * Move forward, when it touches the top or Boss, remove itself. Damages the boss if it hits the Boss
     */
    public Shot()
    {
        setImage(bullet);
        bullet.scale(25,25);        
    }
    public void act()
    {
        
        setLocation(getX(), getY()-15);
        
        if (getY() == 0 || isTouching(Boss.class)) {
            if (isTouching(Boss.class))
            {
                Boss.bossHP -= 1;
            }
            getWorld().removeObject(this);
        }
    }
}
