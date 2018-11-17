/**
 *
 * @author Chad McLeavy
 */

package cis.pkg18c_final_;

public class CIS18C_Final_ 
{
    public static void main(String[] args) 
    {
        GameManager manager = new GameManager();
        
        //Must be at bottom of function. Anything underneath
        //will not run due to infinite game update loop.
        manager.startGame();
        manager.updateGame();
    }
}