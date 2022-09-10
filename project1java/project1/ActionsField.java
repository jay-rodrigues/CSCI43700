import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ActionsField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActionsField extends TextBox
{
    /**
     * Act - do whatever the ActionsField wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public ActionsField()
    {
        
        GreenfootImage textImage = new GreenfootImage("", 28, Color.BLACK, new Color(0, 0, 0, 0));
        this.setImage(textImage);
        
    }
}
