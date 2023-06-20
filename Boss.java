import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The opponet the player has to defeat
 * 
 * @author Stanley
 * @version June 2023
 */
public class Boss extends Actor
{
    //Static boss variables to use with other actors
    static int bossX;
    static int bossY;
    static int bossPhase;
    static int recoil;
    static int bossHP;
    static boolean bossCollisionDamage;

    int bossAttack = 0;
    int interval = 0;
    int bossAttackCount = 0;
    int bossXv = 0;
    int bossYv = 0;
    int bossTargetX;
    int smokeInterval = 5;
    
    /**
     * Boss action for their attacks and movement
     */
    public void act()
    {
        // Boss switches phases as it gets to lower HP
        bossPhase = (400-bossHP)/100;
        // Only attack when player and boss hp is higher than 0
        if (Car.carHp > 0 && bossHP > 0)
        {
            bossAttack();
        }
        // Move positions according to Xv and Yv
        setLocation(getX()+bossXv, getY()+bossYv);
        bossX = getX();
        bossY = getY();
        // Check if Player takes collision damage
        if (bossCollisionDamage && isTouching(Car.class))
        {
            Car.takeDamage();
        }
        
        smoke();
        // Boss defeat sequence
        if (bossHP < 1)
        {
            bossCollisionDamage = false;
            bossYv = 2;
            bossXv = 0;
            if (Greenfoot.getRandomNumber(10) == 0)
            {
                MyWorld world = (MyWorld) getWorld();
                world.makeExplosion(getX()+Greenfoot.getRandomNumber(75)-75, getY()+Greenfoot.getRandomNumber(75)-75, Greenfoot.getRandomNumber(75)+75, false);
            }
            if (getY() > 400)
            {
                MyWorld world = (MyWorld) getWorld();
                world.makeExplosion(getX(), getY(), 400, false);
                world.victory();
                getWorld().removeObject(this);
            }
        }
    }
    
    //Setting up Boss's attack, time taken decreases with phase
    private void bossAttackSetup()
    {
        if (bossAttackCount == 0)
        {
            bossAttack = Greenfoot.getRandomNumber(3)+1;
            if (bossAttack == 1)
            {
                bossAttackCount = Greenfoot.getRandomNumber(5)+bossPhase*2;
                interval = 150-bossPhase*30;
            }
            if (bossAttack == 2)
            {
                bossAttackCount = Greenfoot.getRandomNumber(4)+bossPhase;
                bossTargetX = Greenfoot.getRandomNumber(500)+50;
                interval = 200-bossPhase*30;
            }
            if (bossAttack == 3)
            {
                bossAttackCount = Greenfoot.getRandomNumber(8)+bossPhase*2;
                interval = 150-bossPhase*30;;
            }
        }
    }
    
    // Boss attack execution, Boss becomes faster with lower HP
    private void bossAttack()
    {
        // Boss moves from the top on screen at the start of the game, then begins to cycle through attacks
        if (bossAttack == 0) {
            setRotation(270);
            setLocation(getX(), getY()+3);
            if (getY() > 100)
            {
                bossAttackSetup();
            }
        } 
        // Percision shot attack, boss fires onto player's location
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
        // Move around and create LaneSplosions
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
        // Scatter shot attack, similar to percision shot
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
    }
    
    // Fire shot directly onto player
    private void percisionShot()
    {
        MyWorld world = (MyWorld) getWorld();
        world.telegraph(Car.carX, Car.carY);
    }
    
    // Fire shot to a random location
    private void scatterShot()
    {
        MyWorld world = (MyWorld) getWorld();
        world.telegraph(Greenfoot.getRandomNumber(500)+50, Greenfoot.getRandomNumber(450)+300);
    }
    
    // Fire a lane of explosions
    private void laneSplosion()
    {
        MyWorld world = (MyWorld) getWorld();
        world.makeLaneSplosion(getX(), getY()+95);
    }
    
    // Smoke indicates how low the Boss HP is at, higher frequency smoke means less HP
    private void smoke()
    {
        if (smokeInterval == 0)
        {
            if (bossHP < 201)
            {
                MyWorld world = (MyWorld) getWorld();
                world.createSmoke(getX()-25, getY()-25);
            }
            else
            {
                smokeInterval = 1;
            }
            if (bossHP < 201)
            {
                smokeInterval = 20;
            }
            if (bossHP < 101)
            {
                smokeInterval = 5;
            }
            if (bossHP < 1)
            {
                smokeInterval = 2;
            }
        }
        smokeInterval -= 1;
    }
}
