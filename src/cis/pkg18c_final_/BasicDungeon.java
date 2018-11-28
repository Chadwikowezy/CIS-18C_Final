/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

import java.util.Random;

public class BasicDungeon extends BaseDungeon
{
    
    BasicDungeon()
    {
        startDungeon();
    }
    
    protected void generateDungeon()
    {
        int randomInt;
        Random rand = new Random();
        BaseRoom generatedRoom;
        
        for (int i = 0; i < 21; i++)
        {
            randomInt = rand.nextInt(3);
            if (randomInt == 0)
                generatedRoom = new BaseRoom();
            else if (randomInt == 1)
                generatedRoom = new EnemyRoom();
            else
                generatedRoom = new LootRoom();
            
            _dungeonRooms.put(i, generatedRoom);
            
            //=========================================
            //Add generatedRoom to graph here
            //=========================================
        }
        
        _startRoom = _dungeonRooms.get(0);
        _endRoom = _dungeonRooms.get(20);
        
        BaseRoom roomToSort;
        for (Integer key : _dungeonRooms.keySet())
        {
            roomToSort = _dungeonRooms.get(key);
            
            if (roomToSort.myRoomType == BaseRoom.RoomType.Navigation)
                _navigationRooms.add(roomToSort);
            else if (roomToSort.myRoomType == BaseRoom.RoomType.Enemy)
                _enemyRooms.add((EnemyRoom)roomToSort);
            else if (roomToSort.myRoomType == BaseRoom.RoomType.Loot)
                _lootRooms.add((LootRoom)roomToSort);
        }
    }
    protected void startDungeon()
    {
        generateDungeon();
        _currentPlayerRoom = _startRoom;
        System.out.println("You've entered the dungeon!\nFind your way out.");
        
        _currentPlayerRoom.enterRoom();
    }
    protected void completeDungeon()
    {
        System.out.println("You've found the exit room and completed the dungeon!");
        //Add restart functionality if we have time
    }
}
