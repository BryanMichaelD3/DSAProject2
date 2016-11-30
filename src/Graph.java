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