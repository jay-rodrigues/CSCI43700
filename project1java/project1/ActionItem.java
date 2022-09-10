import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author (Jason Rodrigues) 
 * @version (0.1)
 */
public class ActionItem extends ActionField
{
    public String name;
    /**
     * Act - do whatever the InventoryItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            ((MyWorld) getWorld()).parseActions(this.name);

        }
    }
    
    public ActionItem(String name)
    {
        super(name);
        this.name = name;
        setImage(new GreenfootImage(name, 20, Color.BLACK, null));
    }
}
