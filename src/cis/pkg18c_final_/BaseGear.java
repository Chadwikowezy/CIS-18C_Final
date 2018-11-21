/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

import java.util.Random;

public class BaseGear 
{
    public enum GearType { Helmet, ChestPiece, Gauntlets, Cuirass, Boots, Weapon }
    protected GearType _gearType;
    
    protected int _healthIncrease;
    protected int _attackIncrease;
    protected int _defenseIncrease;
    protected int _healIncrease;
    
    protected String _gearString;
    
    public GearType getGearType()
    { return _gearType; }
    public int getHealthIcrease()
    { return _healthIncrease; }
    public int getAttackIncrease()
    { return _attackIncrease; }
    public int getDefenseIncrease()
    { return _defenseIncrease; }
    public int getHealIncrease()
    { return _healIncrease; }
    
    BaseGear()
    {
        Random rand = new Random();
        _gearType = GearType.values()[rand.nextInt(5)];
        _healthIncrease = rand.nextInt(20);
        _attackIncrease = rand.nextInt(5);
        _defenseIncrease = rand.nextInt(3);
        _healIncrease = rand.nextInt(3);
    }
    public String toString()
    {
        _gearString = new StringBuilder()
                        .append("Gear Type: ").append(_gearType)
                        .append("\nHealth: ").append(_healthIncrease)
                        .append("\nAttack: ").append(_attackIncrease)
                        .append("\nDefense: ").append(_defenseIncrease)
                        .append("\nHeal: ").append(_healIncrease)
                        .toString();
        
        return _gearString;
    }
}
