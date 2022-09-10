/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Object
{
    // instance variables - replace the example below with your own
    public double attackPower;
    
    public Weapon(String name, String description, double attackPower)
    {
        super(name, description);
        this.attackPower = attackPower;
        if(this.name.equalsIgnoreCase("hands"))
        {
            this.isDroppable = false;
        }
    }
    
    
    
}
