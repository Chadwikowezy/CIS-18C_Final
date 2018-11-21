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
    
    Enemy()
    {
        Random rand = new Random();
        int nameInt = rand.nextInt(2);
        
        if (nameInt == 0)
            name = "Dat One Guy";
        else if (nameInt == 1)
            name = "Dat Other Guy";
        else
            name = "Dat Other Other Guy";
        health = rand.nextInt(5) + 15;
        attack = rand.nextInt(4) + 1;
        defense = rand.nextInt(2) + 1;
        isDefending = false;
    }
    
    public void takeDamage(int damage)
    {
        health -= damage;
        if (health < 0)
            health = 0;
        
        toString();
    }
}
