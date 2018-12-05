package cis.pkg18c_final_;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jesus Ramos
 */
public class BaseRoom 
{
    public enum RoomType { Navigation, Enemy, Loot }
    protected RoomType myRoomType;
    protected String description;
    private int numOfTotalDescriptions = 21;
    protected Boolean isExitRoom;
    private static Random random = new Random();
    protected Edge[] myEdges = new Edge[3];
    protected Scanner inputScanner;
    
    BaseRoom()
    {
        myRoomType = RoomType.Navigation;
        int rand = random.nextInt(numOfTotalDescriptions);
        setDescription(rand);
    }

    public String getDescription() 
    { return description; }
    
    private void setDescription(int disc)
    {
        switch(disc)
        {
            case 1:
                description = "A desolate stone-walled room. A single candle burns in the corner."
                        + "There's a pair of broken chains on the other side of the room.";
                break;
            case 2:
                description = "A small secluded graveyard full of untended graves. You can hear the souls of the damned"
                        + " calling out to you. Be wary that you don't end up along with them...";
                break;
            case 3:
                description = "A dark damp room. There's an empty, opened cage in the corner."
                        + "There appears to be a set of ragged clothing within.";
                break;
            case 4:
                description = "A large room full of decrepit furniture.";
                break;
            case 5:
                description = "A hidden archive that houses knowledge lost to the ages. Rumor has it that"
                        + " guardians roam around, carefully keeping watch over the precious secrets"
                        + " that are contained within.";
                break;
            case 6:
                description = "A small alter room covered in ornate decorations. Many holymen would consider"
                        + "this place to be a...";
                break;
            case 7:
                description = "Default dialogue";
                break;
            case 8:
                description = "Default dialogue";
                break;
            case 9:
                description = "Default dialogue";
                break;
            case 10:
                description = "Default dialogue";
                break;
            case 11:
                description = "Default dialogue";
                break;
            case 12:
                description = "Default dialogue";
                break;
            case 13:
                description = "Default dialogue";
                break;
            case 14:
                description = "Default dialogue";
                break;
            case 15:
                description = "Default dialogue";
                break;
            case 16:
                description = "Default dialogue";
                break;
            case 17:
                description = "Default dialogue";
                break;
            case 18:
                description = "Default dialogue";
                break;
            case 19:
                description = "Default dialogue";
                break;
            case 20:
                description = "Default dialogue";
                break;
            default:
                description = "You can see nothing in this room, for it is a void.";
                break;
        }
    }

    public Boolean getIsExitRoom()
    { return isExitRoom; }

    public void setIsExitRoom(Boolean isExitRoom)
    { this.isExitRoom = isExitRoom; }
    
    public RoomType getRoomType()
    { return myRoomType; }
    
    public void addRoomEdge(int edgeDir, BaseRoom edgeDestination)
    { myEdges[edgeDir] = (new Edge(this, edgeDestination)); }
    
    public Edge[] getRoomEdges()
    { return myEdges; }
    
    public void enterRoom() //override this in subclasses for abstract functionality
    { 
        inputScanner = new Scanner(System.in);
        
        if (myEdges[0] == null && myEdges[1] == null && myEdges[2] == null)
        {
            int randDir = new Random().nextInt(3);
            
            if (randDir == 0)
                myEdges[0] = new Edge(this, GameManager.getInstance().getCurrentDungeon().createNewRoom());
            else if (randDir == 1)
                myEdges[1] = new Edge(this, GameManager.getInstance().getCurrentDungeon().createNewRoom()); 
            else
                myEdges[2] = new Edge(this, GameManager.getInstance().getCurrentDungeon().createNewRoom()); 
        }
        
        System.out.println("\n============================="
                         + "\nYou've entered an empty room!");
        System.out.println(description);
        displayRoomOptions();
    }
    public void displayRoomOptions() //override this in subclasses for custom displays
    { 
        System.out.println("\nWould you like to...");
        System.out.println("    1. Move forward");
        System.out.println("    2. Move left");
        System.out.println("    3. Move right");
        
        processOptionSelection(inputScanner.nextInt());
    }
    public void processOptionSelection(int userSelection) //override this in subclasses for abstract functionality
    {
        if (userSelection < 1)
            userSelection = 1;
        else if (userSelection > 3)
            userSelection = 3;
        
        if (myEdges[userSelection - 1] != null)
            GameManager.getInstance().getCurrentDungeon().movePlayer(myEdges[userSelection - 1].getPosB());
        else
        {
            System.out.println("Oh no... It looks like that door is stuck. You'll have to go another direction.");
            displayRoomOptions();
        }
    }
}