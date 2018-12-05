package cis.pkg18c_final_;

// class to represent a graph object

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Graph
{
	// A list of lists to represent adjacency list
	List<List<Integer>> adj = new ArrayList<>();

	// Constructor to construct graph
	public Graph(List<Edge> edges)
	{
                //List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), 
                //new Edge(2, 3), new Edge(3, 4), new Edge(4, 5), new Edge(5,0));
            
		// allocate memory for adjacency list
		for (int i = 0; i < edges.size(); i++)
                    adj.add(i, new ArrayList<>());
             
		// add edges to the undirected graph
		for (Edge current : edges)
		{
                    // allocate new node in adjacency List from src to dest
                    adj.get(current.src).add(current.dest);
	
                    // allocate new node in adjacency List from dest to src
                    adj.get(current.dest).add(current.src);
		}
	}
        
        public void addEdge(int src, int dest)
        {
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        
        public void removeEdge(int src, int dest)
        {
            adj.get(src).remove(dest);
            adj.get(dest).remove(src);
        }

	// print adjacency list representation of graph
	public void printGraph()
	{
            int src = 0;
            int n = adj.size();

            while (src < n)
            {
                // print current vertex and all its neighboring vertices
                for (int dest : adj.get(src))
                    System.out.print("(" + src + " --> " + dest + ")\t");

                System.out.println();
                src++;
            }
	}
}