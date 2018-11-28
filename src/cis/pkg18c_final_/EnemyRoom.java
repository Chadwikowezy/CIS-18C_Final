package cis.pkg18c_final_;

import java.util.Scanner;

/**
 *
 * @author Jesus Ramos
 */
public class EnemyRoom extends BaseRoom
{
    private Enemy enemy;
    private Scanner inputScanner;

    public Enemy getEnemy() 
    { return enemy; }

    public void setEnemy(Enemy enemy)
    { this.enemy = enemy; }
    
    EnemyRoom()
    {
        myRoomType = RoomType.Enemy;
        enemy = new Enemy();
    }
    
    @Override
    public void enterRoom()
    {
        inputScanner = new Scanner(System.in);
        
        System.out.println("\nYou've entered a monster room!");
        System.out.println(description);
        displayRoomOptions();
    }
    @Override
    public void displayRoomOptions()
    {
        if (GameManager.getInstance().getPlayer().getHealth() <= 0)
            return;
        
        if (enemy.getHealth() > 0)
        {
            System.out.println("\nSTATS...");
            System.out.println(GameManager.getInstance().getPlayer().toString());
            System.out.println(enemy.toString());

            System.out.println("\nWould you like to...");
            System.out.println("    1. Attack");
            System.out.println("    2. Defend");
            System.out.println("    3. Heal");
        }
        else
        {
            System.out.println("\nThe monster is dead!");
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
        if (userSelection < 1)
            userSelection = 1;
        else if (userSelection > 3)
            userSelection = 3;
        
        if (enemy.getHealth() > 0)
        {
            enemy.determineAction();
            if (userSelection == 1)
            {
                if (!enemy.getIsDefending())
                {
                    enemy.takeDamage(GameManager.getInstance().getPlayer().getCurrentAttack());
                    GameManager.getInstance().getPlayer().takeDamage(enemy.getAttack());
                }
                else
                    enemy.takeDamage(GameManager.getInstance().getPlayer().getCurrentAttack() - enemy.getDefense());
            }
            else if (userSelection == 2)
            {
                if (!enemy.getIsDefending())
                {
                    int damageToPlayer = enemy.getAttack() - GameManager.getInstance().getPlayer().getCurrentDefense();
                    if (damageToPlayer >= 1)
                        GameManager.getInstance().getPlayer().takeDamage(damageToPlayer);
                    else
                        GameManager.getInstance().getPlayer().takeDamage(1);
                }
            }
            else if (userSelection == 3)
            {
                GameManager.getInstance().getPlayer().heal();
                GameManager.getInstance().getPlayer().takeDamage(enemy.getAttack());
            }
            
            displayRoomOptions();
        }
        else
        {
            if (userSelection == 1)
            {} //move player to forward room
            else if (userSelection == 2)
            {} //move player to left room
            else if (userSelection == 3)
            {} //move player to right room
            
            inputScanner = null;
        }
    }
}
