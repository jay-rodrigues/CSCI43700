import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class TextBox extends Actor
{
    
    GreenfootImage textArea;
    String currentText = "";
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
    }

    
     
    // method to show, or replace, a text image
    public void showText(String text)
    {
        currentText = text;
        removeTextImage(); // so this method can replace any previous text image shown
        GreenfootImage textImage = new GreenfootImage(text, 22, Color.BLACK, new Color(0, 0, 0, 0));
        textArea = new GreenfootImage(textImage); // textImage used only to size the area
        textArea.drawImage(getWorld().getBackground(), -getX(), -getY()); // replaces image with affected background area (to be retained)
        getWorld().getBackground().drawImage(textImage, getX(), getY()); // draws text image on background image
    }
    
    public String getCurrentText()
    {
        return this.currentText;
    }
 
    // method to remove text image (replace affected background)
    public void removeTextImage()
    {
        if (textArea != null) getWorld().getBackground().drawImage(textArea, getX(), getY());
    }
}
