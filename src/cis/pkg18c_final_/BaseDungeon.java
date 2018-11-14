/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

import java.util.HashMap;
import java.util.List;

public abstract class BaseDungeon 
{
    protected BaseRoom _currentPlayerRoom;
    protected BaseRoom _startRoom;
    protected BaseRoom _endRoom;
    protected HashMap<Integer, BaseRoom> _dungeonRooms = new HashMap<Integer, BaseRoom>();
    protected List<EnemyRoom> _enemyRooms;
    protected List<LootRoom> _lootRooms;
    //protected List<NavigationRoom> _navigationRooms;
    
    abstract protected void generateDungeon();
    abstract protected void startDungeon();
    abstract protected void completeDungeon();
}
