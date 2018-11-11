/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

public class Player 
{
    private int _health;
    private int _baseMaxHealth;
    private int _baseAttack;
    private int _baseDefense;
    private int _baseHeal;
    
    private int _maxHealth;
    private int _attack;
    private int _defense;
    private int _heal;
    
    private BaseGear _helmet;
    private BaseGear _chestPiece;
    private BaseGear _gauntlets;
    private BaseGear _cuirass;
    private BaseGear _boots;
    private BaseGear _weapon;
    
    //region getters and setters
    public int getHealth()
    { return _health; }
    public int getBaseMaxHealth()
    { return _baseMaxHealth; }
    public int getBaseAttack()
    { return _baseAttack; }
    public int getBaseDefense()
    { return _baseDefense; }
    public int getBaseHeal()
    { return _baseHeal; }
    public int getCurrentMaxHealth()
    { return _maxHealth; }
    public int getCurrentAttack()
    { return _attack; }
    public int getCurrentDefense()
    { return _defense; }
    public int getCurrentHeal()
    { return _heal; }
    public BaseGear getHelmet()
    { return _helmet; }
    public BaseGear getChestPiece()
    { return _chestPiece; }
    public BaseGear getGauntlets()
    { return _gauntlets; }
    public BaseGear getCuirass()
    { return _cuirass; }
    public BaseGear getBoots()
    { return _boots; }
    public BaseGear getWeapon()
    { return _weapon; }
    //endregion getters and setters
    
    public void equipGear(BaseGear newGear)
    {
        //Function not finished. Still need to adjust current stat values.
        if (newGear.getGearType() == BaseGear.GearType.Helmet)
            _helmet = newGear;
        else if (newGear.getGearType() == BaseGear.GearType.ChestPiece)
            _chestPiece = newGear;
        else if (newGear.getGearType() == BaseGear.GearType.Gauntlets)
            _gauntlets = newGear;
        else if (newGear.getGearType() == BaseGear.GearType.Cuirass)
            _cuirass = newGear;
        else if (newGear.getGearType() == BaseGear.GearType.Boots)
            _boots = newGear;
        else
            _weapon = newGear;
    }
}
