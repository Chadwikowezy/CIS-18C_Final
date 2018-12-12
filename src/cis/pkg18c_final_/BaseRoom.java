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
                description = "An empty room.";
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
                description = "A small alter room covered in ornate decorations.";
                break;
            case 7:
                description = "A room filled to the brim with chests. One's bound to be a mimic...";
                break;
            case 8:
                description = "A room full of paintings of far away lands.";
                break;
            case 9:
                description = "A blood-soaked room full of guts and body parts. Something big happened here not too long ago...";
                break;
            case 10:
                description = "A barren room. There's a door on the other side with a skeleton engraved into the frame.";
                break;
            case 11:
                description = "A torture chamber filled with nasty devices and human remains. Blood markings are scattered all across.";
                break;
            case 12:
                description = "An upside down room. You wonder how this room was even able to be constructed.";
                break;
            case 13:
                description = "An ornate room that is covered in gilded furnishing. Who knows how much gold was spent docorating this lavish place...";
                break;
            case 14:
                description = "A large room filled with cells.";
                break;
            case 15:
                description = "A seemingly normal room with seemingly regular furniture. It feels out of place considering this is a dungeon.";
                break;
            case 16:
                description = "A completely crystalized room. The light blue crystals that the room is covered in are giving off a large magical energy.";
                break;
            case 17:
                description = "A room covered in runic symbols. Looks like someone attempted to summon something from another plane.";
                break;
            case 18:
                description = "A room covered in demonic etchings. Seems like demons have been using this to traverse here from their hellish homeland.";
                break;
            case 19:
                description = "A room that's completely covered in slime. Must be a slime hive.";
                break;
            case 20:
                description = "A room that feels oddly hot. Perhaps there's something burning in here. You should leave as soon as possible.";
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