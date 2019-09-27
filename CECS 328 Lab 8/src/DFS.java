import java.util.*;
import java.io.*;

public class DFS
{	
	private LinkedList <Integer> adjList[]; //adjListacency Lists representation
	private int vertCount; //V is the count of the vertices
	// This is constructor
	DFS(int v)
	{
		vertCount = v;
		adjList = new LinkedList[v];
		for (int i=0; i<v; ++i)
		{
			adjList[i] = new LinkedList();
		}
	}
	
	//Method for adding the edge in the graph
	void addingTheEdge(int v,int w)
	{
		adjList[v].add(w);
	}
	
	//The DFSTraverse traversal will be displayed here
	void DFSTraverse(int v,boolean visited[])
	{
		
		visited[v] = true;
		System.out.print(v+" ");
		
		
		Iterator<Integer> i = adjList[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
			DFSTraverse(n, visited);
		}
	}
	void DFS(int v)
	{
	  
		boolean visited[] = new boolean[vertCount];
		
		  
		DFSTraverse(v, visited);
	}
	
	// Driver method to
	public static void main(String args[])
	{
	DFS g = new DFS(4);
	
	g.addingTheEdge(0, 1);
	g.addingTheEdge(0, 2);
	g.addingTheEdge(1, 2);
	g.addingTheEdge(2, 0);
	g.addingTheEdge(2, 3);
	g.addingTheEdge(3, 3);
	
	System.out.println("The DFS traversal is given below "+
	"(starting from vertex 1)");
	
	g.DFS(1);
	}
}