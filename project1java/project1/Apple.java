/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends HealableObject 
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class Apple
     */
    public Apple(String name, String description, int healAmount, int uses)
    {
        super(name, description, healAmount, uses);
        this.canHeal = true;
    }

    
}
