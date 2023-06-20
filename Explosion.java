import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Explosion, part of the Boss's attacks, can be damaging and non damaging
 * 
 * @author Stanley
 * @version June 2023
 */
public class Explosion extends Actor
{
    int timer = 0;
    boolean damaging;
    GreenfootImage[] explosion = new GreenfootImage[12];
    GreenfootSound explosionSound = new GreenfootSound("Explosion.mp3");
    /**
     * Cycle through explosion animation, if it is damaging and it comes in contact with Player then Player takes damage
     */
    public Explosion(int s, boolean d)
    {
        damaging = d;
        explosionSound.play();
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
