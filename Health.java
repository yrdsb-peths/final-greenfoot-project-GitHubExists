import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        if (corrisbondingHp >= Car.carHp)
        {
            getWorld().removeObject(this);
        }
    }
}
