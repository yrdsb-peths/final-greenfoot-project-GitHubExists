import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The opponet the player has to defeat
 * 
 * @author Stanley
 * @version June 2023
 */
public class Boss extends Actor
{
    static int bossX;
    static int bossY;
    static int turretDirect;
    static int bossPhase = 1;
    static int recoil = 0;
    static int bossHP = 300;
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
        bossPhase = (400-bossHP)/100;
        
        if (Car.carHp > 0)
        {
            bossAttack();
        }
        
        setLocation(getX()+bossXv, getY()+bossYv);
        bossX = getX();
        bossY = getY();
        
        if (bossCollisionDamage && isTouching(Car.class))
        {
            Car.takeDamage();
        }
     }
    
    private void bossAttackSetup()
    {
        if (bossAttackCount == 0)
        {
            bossAttack = Greenfoot.getRandomNumber(2+bossPhase)+1;
            if (bossAttack == 1)
            {
                bossAttackCount = Greenfoot.getRandomNumber(5)+3;
                interval = 150-bossPhase*30;
            }
            if (bossAttack == 2)
            {
                bossAttackCount = Greenfoot.getRandomNumber(4)+1;
                bossTargetX = Greenfoot.getRandomNumber(500)+50;
                interval = 200-bossPhase*30;
            }
            if (bossAttack == 3)
            {
                bossAttackCount = Greenfoot.getRandomNumber(8)+3;
                interval = 150-bossPhase*30;;
            }
        }
    }
    
    private void bossAttack()
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
                interval = 35-bossPhase*5;;
                bossAttackCount -= 1;
                bossAttackSetup();
            }
            
            interval -= 1;
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
                interval = 95-bossPhase*15;;
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
        if (bossAttack == 3)
        {
            if (interval == 0)
            {
                scatterShot();
                interval = 30-bossPhase*8;;
                bossAttackCount -= 1;
                bossAttackSetup();
            }
            
            interval -= 1;
        }
        if (bossAttack == 4)
        {
            if (bossAttackCount == 3)
            {
                bossYv += 1;
                if (bossYv == 9)
                {
                    bossYv = 8;
                }
                if (getX() < 750)
                {
                    getImage().setTransparency(0);
                    interval = 400;
                }
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
