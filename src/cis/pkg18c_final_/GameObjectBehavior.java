/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

abstract public class GameObjectBehavior 
{
    protected long guid;
    abstract void update();
    public void setGUID(long newGuid)
    { guid = newGuid; }
    public long getGUID()
    { return guid; }
}
