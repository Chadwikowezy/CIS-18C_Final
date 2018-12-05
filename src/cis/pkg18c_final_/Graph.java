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
            //List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), 
            //new Edge(2, 3), new Edge(3, 4), new Edge(4, 5), new Edge(5,0));
            randomizer = new Random();

            // allocate memory for adjacency list
            for (int i = 0; i < newRooms.size(); i++)
                addRoomNode(newRooms.get(i));

            // add edges to the undirected graph
//            for (Edge current : edges)
//            {
//                // allocate new node in adjacency List from src to dest
//                adj.get(current.src).add(current.dest);
//
//                // allocate new node in adjacency List from dest to src
//                adj.get(current.dest).add(current.src);
//            }
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