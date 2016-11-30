// Graph class
// Based on code from Frederick Portier's lecture notes
// Written by: Bryan Dorbert and Angela Raymond
// November 29, 2016

// This class is an implementation of the graph data structure. This class has a 
// hasSolution() method that makes the program check if (a, 0, 0) has a solution of 
// (a/2, a/2, 0). If there is a solution it returns true, else it returns false.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// This is an implementation of the graph data structure
public class Graph<T> implements Iterable<T>
{
	protected Map<T, List<T>> neighbors;
	
	public Graph()
	{
		neighbors = new LinkedHashMap<T, List<T>>();
	}
	
	public void add(T v)
	{
		if(!neighbors.containsKey(v))
		{
			neighbors.put(v, new ArrayList<T>());
		}
	}
	
	public void addEdge(T u, T v)
	{
		neighbors.get(u).add(v);
	}
	
	public List<T> neighbors(T u)
	{
		return new ArrayList<T>(neighbors.get(u));
	}
	
	// Checks if there is a solution to the given jug problem
	public boolean hasSolution(T n)
	{
		for(T v:this)
		{
			if(v.hashCode() == n.hashCode())
			{
				return true;
			}
		}
		
		return false;
	}
	
	// Get node count of graph
	public int getNodeCount()
	{
		return neighbors.keySet().size();
	}
	
	// Get edge count of graph
	public int getEdgeCount()
	{
		int count = 0;
		for(Map.Entry<T, List<T>> entry: neighbors.entrySet())
		{
			count += entry.getValue().size();
		}
		
		return count;
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return neighbors.keySet().iterator();
	}
	
	public String toString()
	{
		String str = "";
		
		for(T v:this)
		{
			str += v + " -> ";
			str += neighbors(v);
			str += "\n";
		}
		
		return str;
	}
}