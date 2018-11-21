package cis.pkg18c_final_;

import java.util.Scanner;

/**
 *
 * @author Jesus Ramos
 */
public class LootRoom extends BaseRoom
{
    private BaseGear gearLoot;
    private Scanner inputScanner;
    private boolean equipedGear;

    public BaseGear getGearLoot()
    { return gearLoot; }

    public void setGearLoot(BaseGear gearLoot) 
    { this.gearLoot = gearLoot; }
    
    @Override
    public void enterRoom()
    {
        inputScanner = new Scanner(System.in);
        gearLoot = new BaseGear();
        
        System.out.println("\nYou've entered a loot room!");
        System.out.println(description);
        displayRoomOptions();
    }
    @Override
    public void displayRoomOptions()
    {
        if (GameManager.getInstance().getPlayer().getHealth() <= 0)
            return;
        
        if (!equipedGear)
        {
            BaseGear playerGear = null;
            if (gearLoot.getGearType() == BaseGear.GearType.Helmet)
                playerGear = GameManager.getInstance().getPlayer().getHelmet();
            else if (gearLoot.getGearType() == BaseGear.GearType.ChestPiece)
                playerGear = GameManager.getInstance().getPlayer().getChestPiece();
            else if (gearLoot.getGearType() == BaseGear.GearType.Gauntlets)
                playerGear = GameManager.getInstance().getPlayer().getGauntlets();
            else if (gearLoot.getGearType() == BaseGear.GearType.Cuirass)
                playerGear = GameManager.getInstance().getPlayer().getCuirass();
            else if (gearLoot.getGearType() == BaseGear.GearType.Boots)
                playerGear = GameManager.getInstance().getPlayer().getBoots();
            else if (gearLoot.getGearType() == BaseGear.GearType.Weapon)
                playerGear = GameManager.getInstance().getPlayer().getWeapon();

            System.out.println("\nPLAYER GEAR STATS...");
            if (playerGear != null)
                System.out.println(playerGear.toString());
            else
                System.out.println("You don't have gear in this gear slot yet!");

            System.out.println("\nLOOT GEAR STATS...");
            System.out.println(gearLoot.toString());

            System.out.println("\nWould you like to...");
            System.out.println("    1. Equip Loot");
            System.out.println("    2. Move forward");
            System.out.println("    3. Move left");
            System.out.println("    4. Move right");
        }
        else
        {
            System.out.println("\nLoot Equiped!");
            System.out.println(GameManager.getInstance().getPlayer().toString());
            System.out.println("Would you like to...");
            System.out.println("    1. Move forward");
            System.out.println("    2. Move left");
            System.out.println("    3. Move right");
        }
        
        processOptionSelection(inputScanner.nextInt());
    }
    @Override
    public void processOptionSelection(int userSelection)
    {
        if (!equipedGear)
        {
            if (userSelection < 1)
                userSelection = 1;
            else if (userSelection > 4)
                userSelection = 4;
            
            if (userSelection == 1)
            {
                equipedGear = true;
                GameManager.getInstance().getPlayer().equipGear(gearLoot);
                displayRoomOptions();
            }
            else if (userSelection == 2)
            {} //Move forward
            else if (userSelection == 3)
            {} //Move left
            else if (userSelection == 4)
            {} //Move right
        }
        else
        {
            if (userSelection < 1)
                userSelection = 1;
            else if (userSelection > 3)
                userSelection = 3;
            
            if (userSelection == 1)
            {} //Move forward
            else if (userSelection == 2)
            {} //Move left
            else if (userSelection == 3)
            {} //Move right
        }
        
        inputScanner = null;
    }
}
