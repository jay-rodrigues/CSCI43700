import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class InventoryObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventoryField extends Actor
{
    public String name;
    
    
    /**
     * Act - do whatever the InventoryObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
     public InventoryField(String name)
    {
        this.name = name;
    }
    
    public void setDescription()
    {
        getWorld().showText(this.name, this.getX()+50, this.getY());
    }
    
    public void updateInventory()
    {
        
        int currentX = getX();
        int currentY = getY()+30;
        
        Character player = ((MyWorld) getWorld()).player;
        getWorld().removeObjects(getWorld().getObjects(InventoryItem.class));
        for(Object item: player.inventory)
        {
            if(item == player.inHand)
            {
                InventoryItem newItem = new InventoryItem(item.name +" (in hand)");
                getWorld().addObject(newItem, currentX, currentY);
                currentY += 30;
            }
            else
            {
                InventoryItem newItem = new InventoryItem(item.name);
                getWorld().addObject(newItem, currentX, currentY);
                currentY += 30; 
            }
            
        }
    }
    
}
