/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

public class BaseGear 
{
    public enum GearType { Helmet, ChestPiece, Gauntlets, Cuirass, Boots, Weapon }
    private GearType _gearType;
    
    protected int _healthIncrease;
    protected int _attackIncrease;
    protected int _defenseIncrease;
    protected int _healIncrease;
    
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
}
