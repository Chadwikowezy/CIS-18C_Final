package cis.pkg18c_final_;

import java.util.Random;

/**
 *
 * @author Jesus Ramos
 */
public class BaseRoom 
{
    private String description;
    private int numOfTotalDescriptions = 21;
    private Boolean isExitRoom;
    private static Random random = new Random();
    
    BaseRoom()
    {
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
                description = "";
                break;
            case 2:
                description = "";
                break;
            case 3:
                description = "";
                break;
            case 4:
                description = "";
                break;
            case 5:
                description = "";
                break;
            case 6:
                description = "";
                break;
            case 7:
                description = "";
                break;
            case 8:
                description = "";
                break;
            case 9:
                description = "";
                break;
            case 10:
                description = "";
                break;
            case 11:
                description = "";
                break;
            case 12:
                description = "";
                break;
            case 13:
                description = "";
                break;
            case 14:
                description = "";
                break;
            case 15:
                description = "";
                break;
            case 16:
                description = "";
                break;
            case 17:
                description = "";
                break;
            case 18:
                description = "";
                break;
            case 19:
                description = "";
                break;
            case 20:
                description = "";
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
}