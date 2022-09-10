import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.text.*;
import java.util.Date;
/**
 * Write a description of class SaveGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveGame extends Actor
{
    /**
     * Act - do whatever the SaveGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            saveTheGame();
            
        }
    }
    
    public SaveGame()
    {
        setImage(new GreenfootImage("Save Game", 20, Color.BLACK, null));
    }
    
    public void saveTheGame()
    {
        GameWorld saveWorld = new GameWorld();
        
        saveWorld.player = ((MyWorld) getWorld()).player;
        for(Location l: ((MyWorld) getWorld()).locations)
        {
            saveWorld.locations.add(l);
        }
        for(Character e: ((MyWorld) getWorld()).enemies)
        {
            saveWorld.enemies.add(e);
        }
        saveWorld.startLocation = ((MyWorld) getWorld()).startLocation;
       
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/JaysGame.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(saveWorld);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/JaysGame.ser\n");
            ((MyWorld) getWorld()).setResult("Serialized data is saved in /private/tmp/JaysGame.ser\n");
        } catch (IOException i) {
            i.printStackTrace();
        }
   }
}
