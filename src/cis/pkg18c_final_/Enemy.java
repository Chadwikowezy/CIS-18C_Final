package cis.pkg18c_final_;

import java.util.Random;

/**
 *
 * @author Jesus Ramos
 */
public class Enemy 
{
    private int health;
    private int attack;
    private int defense;
    private String name;
    private String enemyString;
    private boolean isDefending;

    public int getHealth()
    { return health; }

    public void setHealth(int health) 
    { this.health = health; }

    public int getAttack() 
    {  return attack; }

    public void setAttack(int attack) 
    { this.attack = attack; }

    public int getDefense()
    {  return defense; }

    public void setDefense(int defense) 
    { this.defense = defense; }

    public String getName() 
    { return name; }

    public void setName(String name) 
    { this.name = name; }
    
    public boolean getIsDefending()
    { return isDefending; }
    
    Enemy()
    {
        Random rand = new Random();
        int nameInt = rand.nextInt(2);
        
        if (nameInt == 0)
            name = "Imp";
        else if (nameInt == 1)
            name = "Goblin";
        else if (nameInt == 2)
            name = "Hobgoblin";
        else if (nameInt == 3)
            name = "Skeleton";
        else if (nameInt == 4)
            name = "Mimic";
        else if (nameInt == 5)
            name = "Rat";
        else if (nameInt == 6)
            name = "Spider";
        else if (nameInt == 7)
            name = "Undead";
        else if (nameInt == 8)
            name = "Giant Crab";
        else if (nameInt == 9)
            name = "Starved Hound";
        else if (nameInt == 10)
            name = "Werewolf";
        else if (nameInt == 11)
            name = "Slime";
        else if (nameInt == 12)
            name = "Werewolf";
        else if (nameInt == 13)
            name = "Stray Demon";
        else if (nameInt == 14)
            name = "Deranged Adventurer";
        else if (nameInt == 15)
            name = "Wyvern";                      
        else
        {
            name = "Dat Boi";
        }
        health = rand.nextInt(5) + 15;
        attack = rand.nextInt(4) + 1;
        defense = rand.nextInt(2) + 1;
        isDefending = false;
    }
    
    public String toString()//override in subclasses if different monster types are wanted/needed
    {
        enemyString = new StringBuilder()
                        .append("Monster,")
                        .append("\n  Name: ").append(name)
                        .append("\n  Health: ").append(health)
                        .append("\n  Attack: ").append(attack)
                        .append("\n  Defense: ").append(defense)
                        .toString();
        
        return enemyString;
    }
    public void takeDamage(int damage)
    {
        health -= damage;
        if (health < 0)
            health = 0;
        
        toString();
    }
    public void determineAction()
    {
        Random rand = new Random();
        isDefending = rand.nextBoolean();
    }
}
