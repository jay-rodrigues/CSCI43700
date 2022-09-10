import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public Location startLocation;
    public DescriptionField descriptionField;
    public DescriptionField resultField;
    public ActionField actionField;
    public InventoryField inventoryField;
    public DescriptionField healthField;
    public DescriptionField itemDescription;
    public Character player;
    public List<Character> enemies = new ArrayList<Character>();
    public List<Location> locations = new ArrayList<Location>();
    public List<String> availableActions = new ArrayList<String>();
    public List<Object> itemsInRoom = new ArrayList<Object>();
    public List<Object> itemsInInventory = new ArrayList<Object>();
    public MyWorld()
    {
        super(900, 700, 1);

        descriptionField = new DescriptionField();
        addObject(descriptionField, 50, 50);

        resultField = new DescriptionField();
        addObject(resultField, 50, 200);

        healthField = new DescriptionField();
        addObject(healthField, 50, 650);

        actionField = new ActionField("Available Actions:");
        addObject(actionField, 120, 400);
        actionField.setDescription();

        inventoryField = new InventoryField("Player's Inventory:");
        addObject(inventoryField, 480, 400);
        inventoryField.setDescription();

        itemDescription = new DescriptionField();
        addObject(itemDescription, 500, 560);

        addObject(new SaveGame(), 800, 600);

        String decision = Greenfoot.ask("Would you like to: Start a new game or load a game or view instructions? Options: (start, load, instructions, andy)");

        if(decision.equalsIgnoreCase("start"))
        {
            descriptionField.showText("Lets begin");
            prepare();
            updateFields();
            Greenfoot.start();
        }
        else if(decision.equalsIgnoreCase("load"))
        {
            descriptionField.showText("Load is not working yet. As a substitute: You have hereby lost THE GAME \n Yes I mean the game where if you think about it you lose it. You are welcome");
            loadWorld();
        }
        else if(decision.equalsIgnoreCase("instructions"))
        {
            descriptionField.showText("You are assaulting the castle to kill the king and get the treasure\nYou are to find you're way through the castle and kill whatever comes across your path\n You will find various items to help you: stronger weapons, spell books, and healing items\n Clicking on an item in your inventory will put it in your hand");
            descriptionField.showText(descriptionField.getCurrentText() + "\nTo perform an action, just click on the action. \nBe careful though. While death is not the end of the game, \nit will return you to the start. \nWhen you are ready to begin, press reset");
            // descriptionField.showText(descriptionField.getCurrentText() + "\n\n Also, there is a ConcurrentModification Error that I have been unable to fix. \nIf it comes up, just press run and continue with the game");
        }
        else if(decision.equalsIgnoreCase("andy"))
        {
            descriptionField.showText("You have hereby lost THE GAME \n Yes I mean the game where if you think about it you lose it. You are welcome");
        }
        else {
            descriptionField.showText("Incorrect input. Please restart");

        }
        prepare();
    }

    private void loadWorld()
    {
        GameWorld w = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/JaysGame.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            w = (GameWorld) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("GameWorld class not found");
            c.printStackTrace();
            return;
        }
        player = w.player;
        enemies = w.enemies;
        locations = w.locations;
        startLocation = w.startLocation;
        updateFields();
        Greenfoot.start();
      
      
      
   }
   
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        player = new Character("You", 25.0, 1.0,true, null, null, null);
        Character king = new Character("the King", 30.0, 1.3, true, null, null, null);
        Character peasantguard = new Character("Peasant Guard", 10.0, 0.3, true, null, null, null);
        Character peasantguard2 = new Character("Peasant Guard", 10.0, 0.3, true, null, null, null);
        Character peasantguard3 = new Character("Peasant Guard", 10.0, 0.3, true, null, null, null);

        Character knight = new Character("Knight", 20, 1.1, true, null, null, null);
        Character priest = new Character("Priest", 10000, 100.0, true, null, null, null);

        Weapon hands = new Weapon("Hands", "strong fists", 1);
        Weapon excalibur = new Weapon("Excalibur", "the Strongest Sword", 6); 
        Weapon sword = new Weapon("Sword", "a simple sword", 4);
        Apple apple = new Apple("Apple", "an apple that heals when eaten", 7, 3);
        BuffableObject spellbook = new SpellBook("SpellBook", "a book that buffs strength", 0.5);
        HealableObject bandage = new HealableObject("Bandage", "a bandage to nurse your wounds", 13, 1);
        Location castlegates = new Location("Castle Gates");
        Location hallway1 = new Location("Hallway 1");
        Location barracks = new Location("Barracks");
        Location lavatory = new Location("Lavatory");
        Location hallway2 = new Location("Hallway 2");
        Location kitchen = new Location("Kitchen");
        Location diningroom = new Location("Dining Room");
        Location chapel = new Location("Chapel");
        Location throneroom = new Location("Throne Room");
        Location treasureroom = new Location("Treasure Room", true);

        player.setPreviousLocation(castlegates);

        king.setCurrentLocation(throneroom);
        king.addToInventory(excalibur);
        king.setItemInHand(excalibur);

        player.setCurrentLocation(castlegates);
        player.addToInventory(hands);
        player.setItemInHand(hands);

        peasantguard.setCurrentLocation(castlegates);
        peasantguard.addToInventory(hands);
        peasantguard.setItemInHand(hands);

        peasantguard2.setCurrentLocation(barracks);
        peasantguard2.addToInventory(hands);
        peasantguard2.setItemInHand(hands);

        peasantguard3.setCurrentLocation(hallway2);
        peasantguard3.addToInventory(hands);
        peasantguard3.setItemInHand(hands);

        priest.setCurrentLocation(chapel);
        priest.addToInventory(hands);
        priest.setItemInHand(hands);

        knight.setCurrentLocation(diningroom);
        knight.addToInventory(sword);
        knight.setItemInHand(sword);

        castlegates.connectRoom(hallway1);
        hallway1.connectRoom(barracks);
        hallway1.connectRoom(lavatory);
        hallway1.connectRoom(hallway2);
        hallway2.connectRoom(kitchen);
        hallway2.connectRoom(diningroom);
        hallway2.connectRoom(chapel);
        kitchen.connectRoom(diningroom);
        diningroom.connectRoom(throneroom);
        chapel.connectRoom(throneroom);
        throneroom.connectRoom(treasureroom);
        lavatory.connectRoom(throneroom);

        barracks.addItem(new Weapon("Sword", "a simple sword", 5));
        kitchen.addItem(new Apple("Apple", "an apple that heals when eaten", 7, 3));
        chapel.addItem(spellbook);
        lavatory.addItem(bandage);
        locations.add(castlegates);
        locations.add(hallway1);
        locations.add(barracks);
        locations.add(lavatory);
        locations.add(hallway2);
        locations.add(kitchen);
        locations.add(diningroom);
        locations.add(chapel);
        locations.add(throneroom);
        locations.add(treasureroom);

        enemies.add(king);
        enemies.add(peasantguard);
        enemies.add(knight);

        startLocation = castlegates;

    }
    
    public Location getLocationByName(String name)
    {
        for(Location location: locations)
        {
            if(location.name.equalsIgnoreCase(name))
            {
                return location;
            }
        }
        return null;
    }
    
    public Character getCharacterInRoomByName(String name)
    {
        for(Character character: player.currentLocation.characters)
        {
            if(character.name.equalsIgnoreCase(name))
            {
                return character;
            }
        }
        return null;
    }
    
    public boolean roomHasEnemy()
    {
        for(Character character: player.currentLocation.characters)
        {
            System.out.println("Characters in room " + character.name);

            if(!character.name.equalsIgnoreCase(player.name))
            {
                System.out.println(player.currentLocation.name + " room had an enemy in it ");
                return true;
            }
        }
        return false;
    }
    
    public boolean canMoveIntoRoom(Location nextRoom)
    {
        if((player.previousLocation != null) && nextRoom != player.previousLocation)
        {
            if(roomHasEnemy())
            {
                return false;
            }
            return true;
        }
        else{
            return true;
        }
    }
    
    public Character getPlayer()
    {
        return this.player;
    }
    
    public void updateInventoryField()
    {
        inventoryField.updateInventory();

    }
    
    public void updateActionField()
    {
        availableActions.clear();
        for(Location l: player.currentLocation.connectedRooms)
        {
            if(canMoveIntoRoom(l))
            {
                availableActions.add("Move to " + l.name);
            }
        }
        for(Character enemy: player.currentLocation.characters)
        {
            if(!enemy.name.equalsIgnoreCase(player.name))
            {
                availableActions.add("Attack " + enemy.name);
            }
        }
        for(Object obj: player.currentLocation.inventory)
        {
            itemsInRoom.clear();
            availableActions.add("Pickup " + obj.name);
            itemsInRoom.add(obj);
        }
        for(Object obj: player.inventory)
        {
            itemsInInventory.clear();
            if(obj.isDroppable)
            {
                availableActions.add("Drop " + obj.name);
                itemsInInventory.add(obj);
            }
            if(obj.canHeal)
            {
                availableActions.add("Heal with " + obj.name); 
            }
            if(obj.isBuff)
            {
                availableActions.add("Buff with " + obj.name);
            }
        }
        
        actionField.updateActions();
    }
    
    public void setResult(String result)
    {
        resultField.showText(result);
    }
    
    public void setDescription(String desc)
    {
        descriptionField.showText(desc);
    }
    
    public void parseActions(String action)
    {
        if(action.startsWith("Move to "))
        {
            //Perform Logic
            //update description field
            // String roomname = action.substring(action.indexOf("to") +3, action.length());
            String parse[] = action.split("Move to ");
            String roomname = parse[1];
            Location nextRoom = getLocationByName(roomname);
            movePlayer(nextRoom);
        }
        
        if(action.startsWith("Attack "))
        {
            //Perform logic
            String parse[] = action.split("Attack ");
            String enemyname = parse[1];
            Character enemy = getCharacterInRoomByName(enemyname);
            attack(enemy);
        }
        
        

        if(action.startsWith("Pickup "))
        {
            String parse[] = action.split("Pickup ");
            String itemname = parse[1];
            for(Object ob: itemsInRoom)
            {
                if(ob.name.equalsIgnoreCase(itemname))
                {
                    player.pickupItem(ob);
                }
            }
        }
        
        if(action.startsWith("Drop "))
        {
            String parse[] = action.split("Drop ");
            String itemname = parse[1]; 
            for(Object ob: itemsInRoom)
            {
                if(ob.name.equalsIgnoreCase(itemname))
                {
                    player.dropItem(ob);
                }
            }
        }
        
        if(action.startsWith("Heal with "))
        {
            String parse[] = action.split("Heal with ");
            String itemname = parse[1]; 
            for(Object ob: player.inventory)
            {
                if(ob.name.equalsIgnoreCase(itemname))
                {
                    setResult("You have been healed for " + ((HealableObject) ob).performHeal(player));
                    setResult(getResult() + "\n " + ob.name + " has " + ((HealableObject) ob).uses + " uses left");
                }
            }
        }
        if(action.startsWith("Buff with "))
        {
            String parse[] = action.split("Buff with ");
            String itemname = parse[1]; 
            for(Object ob: player.inventory)
            {
                if(ob.name.equalsIgnoreCase(itemname))
                {
                    BuffableObject buff = (BuffableObject) ob;
                    setResult(buff.performBuff(player));
                }
            }
        }
        updateFields();
    }
    
    public void updateDescriptionField()
    {
        String description = "You're current location is " + player.currentLocation.name + "\n";
        String charactersInRoom = "The characters in the room is " + player.name;
        String charactersHPs = "";
        for(Character character: player.currentLocation.characters)
        {
            if(!character.name.equalsIgnoreCase(player.name))
            {
                charactersInRoom += " and " +character.name;
                charactersHPs += "\n" + character.name + "'s HP is: " + character.hp;
            }
        }
        description += " " + charactersInRoom + charactersHPs +  "\n What would you like to do?";
        setDescription(description);
    }
    
    public void updateHealthField()
    {
       healthField.showText("Current HP: " + player.hp); 
    }
    
    public void updateItemDescription(String description)
    {
        itemDescription.showText(description);
    }
    
    public void updateFields()
    {
        updateActionField();
        updateInventoryField();
        updateDescriptionField();
        updateHealthField();
    }
    
    
    
    public void movePlayer(Location newLocation)
    {
        System.out.println("Attempting to move into " + newLocation.name);

        if(canMoveIntoRoom(newLocation))
        {
            player.setPreviousLocation(player.currentLocation);
            player.setCurrentLocation(newLocation);
        }
        if(newLocation.isFinal)
        {
            setDescription("CONGRATULATIONS YOU HAVE FOUND THE TREASURE");
            setResult("This is the end of the game, you have won!\n The Castle is yours!");
        }
    }
    
    public void attack(Character enemy)
    {
        //Initial check to make sure we arent attacking ourselves
        if(!enemy.name.equalsIgnoreCase(player.name))
        {
            //Check if the item in the hand is a weapon
            if(player.inHand.getClass() == Weapon.class)
            {
                double damageDoneToEnemy = player.getDamage();
                double damageDoneToPlayer = enemy.getDamage();
                if(enemy.takeDamage(damageDoneToEnemy))
                {
                    setResult(enemy.name + " has been slain!");
                    removeCharacter(enemy);
                }
                else{
                    setResult("Damage dealt to " + enemy.name + " is " + damageDoneToEnemy);
                    if(player.takeDamage(damageDoneToPlayer))
                    {
                        setResult("You have been slain by " + enemy.name);
                        if(enemy.name.equalsIgnoreCase("priest"))
                            setResult(getResult() + "\nHow dare you strike a man of God.\n Back to the beginning with you");
                        playerDeath();
                    }
                    else
                    {
                        setResult(getResult() + "\n" + enemy.name + " deals you " + damageDoneToPlayer + " damage");
                    }
                }
            }
            else
            {
                setResult("You are not holding a Weapon");
            }
            
        }
    }
    
    public void removeCharacter(Character character)
    {
        character.currentLocation.characters.remove(character);
        character.currentLocation = null;
    }
    
    public void playerDeath()
    {
        setDescription("You have been slain or died tragically. Resetting Game in 5 Seconds");
       
        Greenfoot.delay(500);
        
        Greenfoot.setWorld(new MyWorld());
    }
    
    public String getResult()
    {
        return resultField.getCurrentText();
    }
    
    public void resetFields()
    {
        removeObject(descriptionField);
       
    }
}
