import greenfoot.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character implements java.io.Serializable
{
    // instance variables - replace the example below with your own
    
    public String name;
    public double hp;
    public double maxHP;
    public double damageModifier;
    public Object inHand;
    public List<Object> inventory;
    public Location currentLocation;
    public Location previousLocation;
    public boolean attackable;
    /**
     * Constructor for objects of class Character
     */
    public Character(String name, double hp, double damageModifier, boolean attackable, Object inHand, Location currentLocation, Location previousLocation)
    {
        this.name = name;
        this.hp = hp;
        this.maxHP = hp + 5.0;
        this.inHand = inHand;
        this.damageModifier = damageModifier;
        this.attackable = attackable;
        this.inventory = new ArrayList<Object>();
        this.currentLocation = currentLocation;
        this.previousLocation = previousLocation;
    }
    
    
    
    public void addToInventory(Object a)
    {
        inventory.add(a);
        a.setOwner(this);
        System.out.println(a.name + " was added to " + this.name);
    }
    public void pickupItem(Object item)
    {
        item.setOwner(this);
        inventory.add(item);
        System.out.println(item.name + " was added to " + this.name);
        currentLocation.inventory.remove(item);
    }
    public void dropItem(Object item)
    {
        
        item.setOwner(null);
        inventory.remove(item);
        currentLocation.inventory.add(item);
    
    }
    
    public void removeFromInventory(String itemName)
    {
        for(Object item: inventory)
        {
            if(item.name.equalsIgnoreCase(itemName)){
                item.setOwner(null);
                inventory.remove(item);
                System.out.println(item.name + " was removed from " + this.name);

            }
        }
    }
    
    public void removeFromInventory(Object item)
    {
        if(inventory.contains(item))
        {
            item.setOwner(null);
            inventory.remove(item);
            System.out.println(item.name + " was removed from " + this.name);

        }
    }
    
    public void setCurrentLocation(Location l)
    {
        currentLocation = l;
        l.characters.add(this);
        System.out.println(this.name + "'s current location was updated to " + l.name);

    }
    
    public Location getCurrentLocation()
    {
        return this.currentLocation;
    }
    
    public void setPreviousLocation(Location previous)
    {
        this.previousLocation = previous;
        System.out.println(this.name + "'s previous location was updated to " + previous.name);

    }
    
    public Location getPreviousLocation()
    {
        return this.previousLocation;
    }
    
    public void setItemInHand(Object item)
    {
        if(inventory.contains(item))
        {
            this.inHand = item;
            System.out.println(item.name + " is know in the hands of " + this.name);

        }
    }
    
    public void setItemInHand(String itemname)
    {
        List<Object> tempinventory = inventory;
        for(Object obj: tempinventory)
        {
            if(obj.name.equalsIgnoreCase(itemname))
            {
                inHand = obj;
            }
        }
        
    }
    
    public double getDamage()
    {
        double damageDealt = 1.0;
        Random r = new Random();
        double randomValue = 1 + (3 - 1) * r.nextDouble();
        if(((Weapon) this.inHand) != null)
        {
            damageDealt = damageModifier * ((Weapon) this.inHand).attackPower + randomValue;
            System.out.println("Damage with " + ((Weapon) this.inHand).name + " Modifier: " + damageModifier + " Attack Power " + ((Weapon) this.inHand).attackPower + " Random val: " + randomValue);
            BigDecimal rounded = new BigDecimal(damageDealt);
            BigDecimal finaldamage = rounded.setScale(2, RoundingMode.HALF_UP);
            
            return finaldamage.doubleValue();
        }
        return 0;
    }
    
    //returns false if still alive and true if dead
    public boolean takeDamage(double damage)
    {
        double predamageHP = this.hp;
        if(predamageHP - damage >= 0)
        {
            this.hp = this.hp - damage;
            return false;
        }
        else 
        {
            this.hp = 0;
            return true;
        }
    }
    
    public void death()
    {
        //if char is player 
    }
}
