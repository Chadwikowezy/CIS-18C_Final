package cis.pkg18c_final_;

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
        name = "Default Enemy";
        health = 20;
        attack = 5;
        defense = 2;
    }
}
