/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

import java.util.HashMap;

public abstract class BaseDungeon 
{
    protected BaseRoom _startRoom;
    protected BaseRoom _endRoom;
    protected HashMap<Integer, BaseRoom> _dungeonRooms = new HashMap<Integer, BaseRoom>();
    //add lists for each room class
    
    abstract protected void generateDungeon();
    abstract protected void startDungeon();
    abstract protected void completeDungeon();
}
