/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

public class BasicDungeon extends BaseDungeon
{
    
    public BasicDungeon()
    {
        startDungeon();
    }
    
    protected void generateDungeon()
    {
        //Generate a number of rooms based on current level.
        //Room types are randomized.
        //Sort rooms by type.
       
    }
    protected void startDungeon()
    {
        generateDungeon();
        _currentPlayerRoom = _startRoom;
        System.out.println("You've entered the dungeon!\nFind your way out.");
        
        //============= Testing rooms Remove later ===============
        EnemyRoom testRoom = new EnemyRoom();
        testRoom.enterRoom();
        
        //LootRoom testRoomA = new LootRoom();
        //testRoomA.enterRoom();
        //============= Testing rooms Remove later ==============
    }
    protected void completeDungeon()
    {
        System.out.println("You've found the exit room and completed the dungeon!");
        //Add restart functionality if we have time
    }
}
