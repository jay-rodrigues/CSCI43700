import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Location here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Location implements java.io.Serializable
{
    // instance variables - replace the example below with your own

    public String name;
    public List<Character> characters;
    public List<Object> inventory;
    public List<Location> connectedRooms;
    public boolean isFinal = false;
    /**
     * Constructor for objects of class Location
     */
    public Location(String name)
    {
        this.name = name;
        this.characters = new ArrayList<Character>();
        this.inventory = new ArrayList<Object>();
        this.connectedRooms = new ArrayList<Location>();
    }
    public Location(String name, boolean isFinal)
    {
        this.name = name;
        this.characters = new ArrayList<Character>();
        this.inventory = new ArrayList<Object>();
        this.connectedRooms = new ArrayList<Location>();
        this.isFinal = true;
    }

    public void addCharacter(Character character)
    {
        characters.add(character);
        System.out.println(character.name + " was added to room " + this.name);
    }
    
    public void removeCharacter(Character character)
    {
        if(characters.contains(character))
        {
            characters.remove(character);
            System.out.println(character.name + " was removed from " + this.name);
        }
    }
    
    public void addItem(Object item)
    {
        inventory.add(item);
        System.out.println(item.name + " was added to " + this.name);
    }
    
    public void removeItem(Object item)
    {
        if(inventory.contains(item))
        {
            inventory.remove(item);
            System.out.println(item.name + " was removed from " + this.name);

        }
    }
    
    public void connectRoom(Location room)
    {
        if(!connectedRooms.contains(room))
        {
            connectedRooms.add(room);
            System.out.println(room.name + " was linked to " + this.name);
            room.connectRoom(this);
        }
        
    }
    
}
