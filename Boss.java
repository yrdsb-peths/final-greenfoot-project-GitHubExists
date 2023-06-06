import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    int bossAction = 0;
    static int x;
    static int y;
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        x = getX();
        y = getY();
        if (bossAction == 0) {
            setRotation(270);
            setLocation(x, y+3);
            if (getY() > 100)
            {
                bossAction = 1;
            }
        } 
        if (bossAction == 1) {
            bossAction = Greenfoot.getRandomNumber(2)+1;
        }
        // Add your action code here.
    }
    
    public void bossStart()
    {
        
    }
}
