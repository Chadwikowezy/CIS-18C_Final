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
        //Notify player that they've entered the dungeon
    }
    protected void completeDungeon()
    {
        //Display that the player completed the dungeon
        //and ask what they want to do next.
    }
}
