import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ActionObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActionField extends Actor
{
    public String name;
    
    /**
     * Act - do whatever the ActionObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public ActionField(String name)
    {
        this.name = name;
    }
    
    public void setDescription()
    {
        this.getImage().drawString("", this.getX(), this.getY());
        getWorld().showText(this.name, this.getX()+50, this.getY());
    }
    
     public void updateActions()
    {
        int currentX = getX();
        int currentY = getY()+30;
        List<String> actions = ((MyWorld) getWorld()).availableActions;
        getWorld().removeObjects(getWorld().getObjects(ActionItem.class));

        for(String action: actions)
        {
            ActionItem newItem = new ActionItem(action);
            getWorld().addObject(newItem, currentX, currentY);
            currentY += 30;
        }
    }
}
