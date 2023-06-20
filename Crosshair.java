import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A telegraph to the Boss's attacks
 * 
 * @author Stanley
 * @version June 2023
 */
public class Crosshair extends Actor
{
    GreenfootImage crosshair = new GreenfootImage("images/Crosshair.png");
    /**
     * Telegraph spins, when it stops spinning it creates a damaging explosion on where the Crosshair is
     */
    int size = 145;
    double rotation = 20;
    public Crosshair()
    {
        setImage(crosshair);
        crosshair.scale(size,size);
        setRotation(Greenfoot.getRandomNumber(360));
    }
    
    public void act()
    {
        crosshair.scale(size,size);
        setRotation(getRotation()+(int)rotation);
        rotation -= 0.25;
        size = size-(size-140)/4;
        if (rotation == 0 || Boss.bossHP < 1)
        {
            if (Boss.bossHP > 1)
            {
                Boss.recoil = 10;
                MyWorld world = (MyWorld) getWorld();
                world.makeExplosion(getX(), getY(), 150, true);
            }
            getWorld().removeObject(this);
        }
    }
}


