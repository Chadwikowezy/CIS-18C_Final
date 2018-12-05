package cis.pkg18c_final_;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jesus Ramos
 */
public class EnemyRoom extends BaseRoom
{
    private Enemy enemy;

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
        
        if (myEdges[0] == null && myEdges[1] == null && myEdges[2] == null)
        {
            int randDir = new Random().nextInt(3);
            
            if (randDir == 0)
                myEdges[0] = new Edge(this, GameManager.getInstance().getCurrentDungeon().createNewRoom());
            else if (randDir == 1)
                myEdges[1] = new Edge(this, GameManager.getInstance().getCurrentDungeon().createNewRoom()); 
            else
                myEdges[2] = new Edge(this, GameManager.getInstance().getCurrentDungeon().createNewRoom()); 
        }
        
        System.out.println("\n=============================="
                         + "\nYou've entered a monster room!");
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
            if (myEdges[userSelection - 1] != null)
                GameManager.getInstance().getCurrentDungeon().movePlayer(myEdges[userSelection - 1].getPosB());
            else
            {
                System.out.println("Oh no... It looks like that door is stuck. You'll have to go another direction.");
                displayRoomOptions();
            }
            
            inputScanner = null;
        }
    }
}
