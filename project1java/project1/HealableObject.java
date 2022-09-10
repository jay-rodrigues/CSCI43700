import greenfoot.*;
/**
 * Write a description of class HealableObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealableObject extends Object
{
    // instance variables - replace the example below with your own
    public double healAmount;
    public int uses;
    /**
     * Constructor for objects of class Apple
     */
    public HealableObject(String name, String description, int healAmount, int uses)
    {
        super(name, description);
        this.healAmount = healAmount;
        this.canHeal = true;
        this.uses = uses;
    }
    
    public double performHeal(Character character)
    {
        if(uses > 0)
        {
            if(character.hp + healAmount > character.maxHP)
            {
                double amountHealed = character.maxHP - character.hp;
                character.hp = character.maxHP;
                uses-=1;
                return amountHealed;
            }
            else
            {
                character.hp += healAmount;
                uses-=1;
                return healAmount;
            }
            
            
        }
        else
        {
            return 0;
        }
    }
    
}
