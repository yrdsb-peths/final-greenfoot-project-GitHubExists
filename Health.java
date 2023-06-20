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
     * Displays player HP, removes one of itself when Player takes damage
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
