/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

import java.util.HashMap;

public class GameManager extends GameObjectBehavior
{
    //region Singleton behavior
    private static GameManager _instance;
    public static GameManager getInstance()
    {
        if (_instance == null)
            _instance = new GameManager();
        
        return _instance;
    }
    //endregion singleton behavior
    
    private boolean _isRunning;
    private int _nextObjectKey;
    private long _currentGameTime;
    private long _updateTimer;
    private long _updateInterval;
    private HashMap<Integer, GameObjectBehavior> _allObjects = new HashMap<Integer, GameObjectBehavior>();
    
    public GameManager()
    {
        //setup game
        _isRunning = true;
        _nextObjectKey = 0;
        _currentGameTime = System.currentTimeMillis();
        _updateInterval = 100;//100 miliseconds = 0.1 secs
        _updateTimer = 0;
        
        subscribeToUpdate(this);
        updateGame();
    }
    public void subscribeToUpdate(GameObjectBehavior objectToSub)
    {
        objectToSub.setGUID(_nextObjectKey);
        _allObjects.put(_nextObjectKey, objectToSub);
        _nextObjectKey++;
    }
    public void unsubscribeFromUpdate(GameObjectBehavior objectToUnsub)
    {
        _allObjects.remove(objectToUnsub.getGUID());
    }
    
    private void updateGame()
    {
        while (_isRunning)
        {
            _updateTimer += System.currentTimeMillis() - _currentGameTime;
            _currentGameTime = System.currentTimeMillis();
            
            if (_updateTimer >= _updateInterval)
            {
                _updateTimer = 0;
                
                for(Integer key : _allObjects.keySet())
                    _allObjects.get(key).update();
            }
        }
    }
    
    //region GameObjectBehavior
    @Override
    void update()
    { }
    //endregion GameObjectBehavior
}
