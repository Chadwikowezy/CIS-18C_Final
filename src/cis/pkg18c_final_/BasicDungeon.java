/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

import java.util.Random;

public class BasicDungeon extends BaseDungeon
{    
    protected void generateDungeon()
    {
        _dungeonGraph = new Graph();
        BaseRoom generatedRoom;
        
        for (int i = 0; i < 21; i++)
        {
            generatedRoom = createNewRoom();
            
            _dungeonRooms.put(i, generatedRoom);
            _dungeonGraph.addRoomNode(generatedRoom);
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
        _winningRoomNumber = new Random().nextInt(26) + 5;
        _currentRoomNumber = 1;
        System.out.println("======================================"
                        + "\n     You've entered the dungeon!"
                        + "\n          Find your way out."
                        + "\n=====================================");
        
        _currentPlayerRoom.enterRoom();
    }
    protected void completeDungeon()
    {
        System.out.println("\n====================================================="
                         + "\nYou've found the exit room and completed the dungeon!"
                         + "\n=====================================================");
        //Add restart functionality if we have time
    }
    public void movePlayer(BaseRoom targetRoom)
    {
        _currentRoomNumber++;
        _currentPlayerRoom = targetRoom;
        
        if (_currentRoomNumber != _winningRoomNumber)
            _currentPlayerRoom.enterRoom();
        else
            completeDungeon();
    }
    
    int randomInt;
    Random rand = new Random();
    public BaseRoom createNewRoom()
    {
        BaseRoom newRoom;
        randomInt = rand.nextInt(3);
        
        if (randomInt == 0)
            newRoom = new BaseRoom();
        else if (randomInt == 1)
            newRoom = new EnemyRoom();
        else
            newRoom = new LootRoom();
        
        return newRoom;
    }
}
