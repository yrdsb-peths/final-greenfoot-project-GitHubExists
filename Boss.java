import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    static int bossX;
    static int bossY;
    static int turretDirect;
    
    int bossAttack = 0;
    
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        if (bossAttack == 0) {
            setRotation(270);
            turretDirect = 270;
            setLocation(getX(), getY()+3);
            if (getY() > 100)
            {
                bossAttack = 1;
            }
        } 
        if (bossAttack == 1) {
            bossAttack = Greenfoot.getRandomNumber(2)+1;
            percisionShot();
        }
        if (bossAttack == 2) {
            
        }
        bossX = getX();
        bossY = getY();
        // Add your action code here.
    }
    
    private void percisionShot()
    {
        MyWorld world = (MyWorld) getWorld();
        world.telegraph(300, 300);
    }
}
