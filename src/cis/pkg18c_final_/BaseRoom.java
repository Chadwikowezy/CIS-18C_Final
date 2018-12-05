package cis.pkg18c_final_;

import java.util.ArrayList;
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
    private Edge[] myEdges = new Edge[3];
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
                description = "Default dialogue";
                break;
            case 2:
                description = "Default dialogue";
                break;
            case 3:
                description = "Default dialogue";
                break;
            case 4:
                description = "Default dialogue";
                break;
            case 5:
                description = "Default dialogue";
                break;
            case 6:
                description = "Default dialogue";
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
        
        System.out.println("\nYou've entered an empty room!");
        System.out.println(description);
        displayRoomOptions();
    }
    public void displayRoomOptions() //override this in subclasses for custom displays
    { 
        System.out.println("\nWould you like to...");
        System.out.println("    1. Move forward");
        System.out.println("    2. Move left");
        System.out.println("    3. Move right");
    }
    public void processOptionSelection(int userSelection) //override this in subclasses for abstract functionality
    {}
}