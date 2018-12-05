package cis.pkg18c_final_;

// class to represent a graph object

import java.util.ArrayList;
import java.util.Random;

class Graph
{
	// A list of lists to represent adjacency list
	private BaseRoom rootRoom;
        private Random randomizer;

	// Constructor to construct graph
        public Graph()
        {
            randomizer = new Random();
        }
	public Graph(ArrayList<BaseRoom> newRooms)
	{
            randomizer = new Random();

            for (int i = 0; i < newRooms.size(); i++)
                addRoomNode(newRooms.get(i));
	}
        
        public void addRoomNode(BaseRoom newRoom)
        {
            if (rootRoom == null)
            {
                rootRoom = newRoom;
                return;
            }
            
            boolean roomAdded = false;
            int randomRoomDir = randomizer.nextInt(3);
            BaseRoom currentRoom = rootRoom;
            
            while (!roomAdded)
            {
                randomRoomDir = randomizer.nextInt(3);
                
                if (currentRoom.getRoomEdges()[randomRoomDir] == null)
                {
                    currentRoom.addRoomEdge(randomRoomDir, newRoom);
                    roomAdded = true;
                }
                else
                    currentRoom = currentRoom.getRoomEdges()[randomRoomDir].getPosB();
            }
            
            currentRoom.getRoomEdges()[randomRoomDir].getPosB().getDescription();
        }
        
        public void removeEdge(int src, int dest)
        {
            //adj.get(src).remove(dest);
            //adj.get(dest).remove(src);
        }

	// print adjacency list representation of graph
	public void printGraph()
	{
//            int src = 0;
//            int n = adj.size();
//
//            while (src < n)
//            {
//                // print current vertex and all its neighboring vertices
//                for (int dest : adj.get(src))
//                    System.out.print("(" + src + " --> " + dest + ")\t");
//
//                System.out.println();
//                src++;
//            }
	}
}