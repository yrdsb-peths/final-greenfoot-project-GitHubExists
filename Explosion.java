import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    int timer = 0;
    boolean damaging;
    GreenfootImage[] explosion = new GreenfootImage[12];
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Explosion(int s, boolean d)
    {
        damaging = d;
        for (int i = 0; i < explosion.length; i++)
        {
            explosion[i] = new GreenfootImage("images/Explosion/"+i+".png");
            explosion[i].scale(s,s);
        }
    }
    public void act()
    {
        // Add your action code here.
        timer += 1;
        setImage(explosion[timer/2]);
        if (isTouching(Car.class) && damaging)
        {
            Car.takeDamage();
        }
        if (timer == 2*11)
        {
            getWorld().removeObject(this);
        }
    }
}
