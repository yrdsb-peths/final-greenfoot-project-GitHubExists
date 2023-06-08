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
    static int bossPhase = 1;
    static int recoil = 0;
    static boolean bossCollisionDamage = true;

    int bossAttack = 0;
    int interval = 0;
    int bossAttackCount = 0;
    int bossXv = 0;
    int bossYv = 0;
    int bossTargetX;
    
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
                bossAttackSetup();
            }
        } 
        if (bossAttack == 1) 
        {
            if (interval == 0)
            {
                percisionShot();
                interval = 30;
                bossAttackCount -= 1;
                recoil = 10;
                bossAttackSetup();
            }
            
            interval -= 1;
            //bossAttack = Greenfoot.getRandomNumber(2)+1;
        }
        if (bossAttack == 2) {
            if (Math.abs(getX()-bossTargetX) < 20)
            {
                recoil = 15;
                laneSplosion();
                bossAttackCount -= 1;
                bossAttackSetup();
                bossXv = 0;
                bossTargetX = Greenfoot.getRandomNumber(500)+50;
                interval = 80;
            }
            else
            {
                if (interval < 1)
                {
                    if (bossTargetX < getX())
                    {
                        bossXv = -6;
                    }
                    else
                    {
                        bossXv = 6;
                    }
                }
                interval -= 1;
            }
        }
        setLocation(getX()+bossXv, getY()+bossYv);
        bossX = getX();
        bossY = getY();
        // Add your action code here.
    }
    
    private void bossAttackSetup()
    {
        if (bossAttackCount == 0)
        {
            bossAttack = Greenfoot.getRandomNumber(1+bossPhase)+1;
            if (bossAttack == 1)
            {
                bossAttackCount = Greenfoot.getRandomNumber(5)+3;
                interval = 30;
            }
            if (bossAttack == 2)
            {
                bossAttackCount = Greenfoot.getRandomNumber(4)+1;
                bossTargetX = Greenfoot.getRandomNumber(500)+50;
                interval = 80;
            }
        }
    }
    
    private void percisionShot()
    {
        MyWorld world = (MyWorld) getWorld();
        world.telegraph(Car.carX, Car.carY);
    }
    
    private void scatterShot()
    {
        MyWorld world = (MyWorld) getWorld();
        world.telegraph(Greenfoot.getRandomNumber(500)+50, Greenfoot.getRandomNumber(450)+300);
    }
    
    private void laneSplosion()
    {
        MyWorld world = (MyWorld) getWorld();
        world.makeLaneSplosion(getX(), getY()+95);
    }
}
