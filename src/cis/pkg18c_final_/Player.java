/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

public class Player extends GameObjectBehavior
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
    
    private String _playerString;
    
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
    public String toString()
    { return _playerString; }
    //endregion getters and setters
    
    public void equipGear(BaseGear newGear)
    {
        //Function not finished. Still need to adjust current stat values.
        if (newGear.getGearType() == BaseGear.GearType.Helmet)
        {
            if (_helmet != null)
            {
                _maxHealth -= _helmet.getHealthIcrease();
                _attack -= _helmet.getAttackIncrease();
                _defense -= _helmet.getDefenseIncrease();
                _heal -= _helmet.getHealIncrease();
            }
            
            _helmet = newGear;
            _maxHealth += _helmet.getHealthIcrease();
            _attack += _helmet.getAttackIncrease();
            _defense += _helmet.getDefenseIncrease();
            _heal += _helmet.getHealIncrease();
        }
        else if (newGear.getGearType() == BaseGear.GearType.ChestPiece)
        {
            if (_chestPiece != null)
            {
                _maxHealth -= _chestPiece.getHealthIcrease();
                _attack -= _chestPiece.getAttackIncrease();
                _defense -= _chestPiece.getDefenseIncrease();
                _heal -= _chestPiece.getHealIncrease();
            }
            
            _chestPiece = newGear;
            _maxHealth += _chestPiece.getHealthIcrease();
            _attack += _chestPiece.getAttackIncrease();
            _defense += _chestPiece.getDefenseIncrease();
            _heal += _chestPiece.getHealIncrease();
        }
        else if (newGear.getGearType() == BaseGear.GearType.Gauntlets)
        {
            if (_gauntlets != null)
            {
                _maxHealth -= _gauntlets.getHealthIcrease();
                _attack -= _gauntlets.getAttackIncrease();
                _defense -= _gauntlets.getDefenseIncrease();
                _heal -= _gauntlets.getHealIncrease();
            }
            
            _gauntlets = newGear;
            _maxHealth += _gauntlets.getHealthIcrease();
            _attack += _gauntlets.getAttackIncrease();
            _defense += _gauntlets.getDefenseIncrease();
            _heal += _gauntlets.getHealIncrease();
        }
        else if (newGear.getGearType() == BaseGear.GearType.Cuirass)
        {
            if (_cuirass != null)
            {
                _maxHealth -= _cuirass.getHealthIcrease();
                _attack -= _cuirass.getAttackIncrease();
                _defense -= _cuirass.getDefenseIncrease();
                _heal -= _cuirass.getHealIncrease();
            }
            
            _cuirass = newGear;
            _maxHealth += _cuirass.getHealthIcrease();
            _attack += _cuirass.getAttackIncrease();
            _defense += _cuirass.getDefenseIncrease();
            _heal += _cuirass.getHealIncrease();
        }
        else if (newGear.getGearType() == BaseGear.GearType.Boots)
        {
            if (_boots != null)
            {
                _maxHealth -= _boots.getHealthIcrease();
                _attack -= _boots.getAttackIncrease();
                _defense -= _boots.getDefenseIncrease();
                _heal -= _boots.getHealIncrease();
            }
            
            _boots = newGear;
            _maxHealth += _boots.getHealthIcrease();
            _attack += _boots.getAttackIncrease();
            _defense += _boots.getDefenseIncrease();
            _heal += _boots.getHealIncrease();
        }
        else
        {
            if (_weapon != null)
            {
                _maxHealth -= _weapon.getHealthIcrease();
                _attack -= _weapon.getAttackIncrease();
                _defense -= _weapon.getDefenseIncrease();
                _heal -= _weapon.getHealIncrease();
            }
            
            _weapon = newGear;
            _maxHealth += _weapon.getHealthIcrease();
            _attack += _weapon.getAttackIncrease();
            _defense += _weapon.getDefenseIncrease();
            _heal += _weapon.getHealIncrease();
        }
    }
    public void takeDamage(int damage)
    {
        _health -= damage;
        
        if (_health <= 0)
            _health = 0;
    }
    public void heal()
    {
        _health += _heal;
        
        if (_health > _maxHealth)
            _health = _maxHealth;
    }
    
    Player()
    {
        _health = 100;
        _baseMaxHealth = 100;
        _baseAttack = 10;
        _baseDefense = 5;
        _baseHeal = 3;
        
        _maxHealth = 100;
        _attack = 10;
        _defense = 10;
        _heal = 3;
        
        _playerString = new StringBuilder()
                        .append("You,")
                        .append("\n  Health: ").append(_health).append("/").append(_maxHealth)
                        .append("\n  Attack: ").append(_attack)
                        .append("\n  Defense: ").append(_defense)
                        .append("\n  Heal: ").append(_heal)
                        .toString();
    }
    @Override
    void update() 
    { }
}
