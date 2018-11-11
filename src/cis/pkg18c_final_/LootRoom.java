package cis.pkg18c_final_;

/**
 *
 * @author Jesus Ramos
 */
public class LootRoom extends BaseRoom
{
    private BaseGear gearLoot;

    public BaseGear getGearLoot()
    { return gearLoot; }

    public void setGearLoot(BaseGear gearLoot) 
    { this.gearLoot = gearLoot; }
}
