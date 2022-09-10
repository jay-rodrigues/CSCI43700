/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class Object implements java.io.Serializable 
{
    // instance variables - replace the example below with your own
    public String name;
    public String description;
    public Character owner;
    public boolean isDroppable = true;
    public boolean canHeal = false;
    public boolean isBuff = false;
    /**
     * Constructor for objects of class Object
     */
    public Object(String name, String description)
    {
        this.name = name;
        this.description = description;
        
    }
    
    public void setOwner(Character character)
    {
        this.owner = character;
        if(character != null)
        {
            System.out.println(this.name + " is now owned by " + character.name);
        }
    }

    
   
}
