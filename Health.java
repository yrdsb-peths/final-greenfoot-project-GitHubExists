import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player health
 * 
 * @author Stanley
 * @version June 2023
 */
public class Health extends Actor
{    
    int corrisbondingHp;
    
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Health(int hp)
    {
        corrisbondingHp = hp;
    }
    
    public void act()
    {
        if (corrisbondingHp >= Car.carHp || Boss.bossHP < 1)
        {
            MyWorld world = (MyWorld) getWorld();
            world.decreaseScore();
            getWorld().removeObject(this);
        }
    }
}
