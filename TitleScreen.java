import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Stanley 
 * @version June 2023
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Unrealistic Tank Fight", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(565, 800, 1);
        
        addObject(titleLabel, 275, 110);
        prepare();
    }
    
    public void act()
    {
        // Start game when space bar is pressed
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    { 
        Label label = new Label("Use <arrow keys> to Move", 40);
        addObject(label,275,550);
        Label label2 = new Label("Press <space> to Shoot", 40);
        addObject(label2,275,600);
        Label label3 = new Label("Press <space> to Start", 40);
        addObject(label3,275,650);
    }
}
