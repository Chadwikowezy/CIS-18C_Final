/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class BaseDungeon 
{
    protected BaseRoom _currentPlayerRoom;
    protected BaseRoom _startRoom;
    protected BaseRoom _endRoom;
    protected HashMap<Integer, BaseRoom> _dungeonRooms = new HashMap<Integer, BaseRoom>();
    protected ArrayList<EnemyRoom> _enemyRooms = new ArrayList<EnemyRoom>();
    protected ArrayList<LootRoom> _lootRooms = new ArrayList<LootRoom>();
    protected ArrayList<BaseRoom> _navigationRooms = new ArrayList<BaseRoom>();
    
    
    abstract protected void generateDungeon();
    abstract protected void startDungeon();
    abstract protected void completeDungeon();
}
