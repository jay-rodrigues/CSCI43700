import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InventoryItem here.
 * 
 * @author 1Jason Rodrigues
 * @version 0.1
 */
public class InventoryItem extends InventoryField
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
            
            if(!this.name.contains("in hand"))
            {
                ((MyWorld) getWorld()).player.setItemInHand(this.name);
                System.out.println("triggered");
                ((MyWorld) getWorld()).updateInventoryField();
               
            }
        }
        
    }
    
    public InventoryItem(String name)
    {
        super(name);
        this.name = name;
        setImage(new GreenfootImage(name, 20, Color.BLACK, null));
    }
    
    
}
