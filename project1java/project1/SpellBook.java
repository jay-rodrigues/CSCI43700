/**
 * Spellbook is a buffable object that buffs strength
 * 
 * @author (Jason Rodrigues) 
 * @version (a version number or a date)
 */
public class SpellBook extends BuffableObject 
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class SpellBook
     */
    public SpellBook(String name, String description, double buffAmount)
    {
        super(name, description, buffAmount);
    }
    
    public String performBuff(Character character)
    {
        character.damageModifier += this.buffAmount;
        character.removeFromInventory(this);
        System.out.println(character.damageModifier);
        return character.name + "'s strength has been buffed by " + this.buffAmount;
    }
   
}
