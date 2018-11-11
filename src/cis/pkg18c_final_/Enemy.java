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
}
