/**
 * Write a description of class BuffableObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class BuffableObject extends Object 
{
    // instance variables - replace the example below with your own
    public double buffAmount;
    
    /**
     * Constructor for objects of class BuffableObject
     */
    public BuffableObject(String name, String description, double buffAmount)
    {
        super(name, description);
        this.isBuff = true;
        this.buffAmount = buffAmount;
    }
    
    abstract String performBuff(Character character);
    

   
}
