import java.util.*;
import java.io.*;
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld implements Serializable 
{
    // instance variables - replace the example below with your own
    

    public Character player;
    public ArrayList<Character> enemies = new ArrayList<Character>();
    public ArrayList<Location> locations = new ArrayList<Location>();
    public Location startLocation;
    
    /**
     * Constructor for objects of class GameWorld
     */
    public GameWorld()
    {
        
    }

    
    
    public void init()
    {
        //Insert initialization procedures
    }
    
    public void process()
    {
        
    }
}
