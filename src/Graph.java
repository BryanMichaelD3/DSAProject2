import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Graph implements Iterable<Node>
{
	protected Map<Node, List<Node>> neighbors;
	
	public Graph()
	{
		neighbors = new LinkedHashMap<Node, List<Node>>();
	}
	
	public void add(Node v)
	{
		if(!neighbors.containsKey(v))
		{
			neighbors.put(v, new ArrayList<Node>());
		}
	}
	
	public void addEdge(Node u, Node v)
	{
		neighbors.get(u).add(v);
	}
	
	public List<Node> neighbors(Node u)
	{
		return new ArrayList<Node>(neighbors.get(u));
	}
	
	public boolean hasSolution(Node n)
	{
		for(Node v:this)
		{
			if(v.hashCode() == n.hashCode())
			{
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public Iterator<Node> iterator()
	{
		return neighbors.keySet().iterator();
	}
	
	public String toString()
	{
		String str = "";
		
		for(Node v:this)
		{
			str += v + " -> ";
			str += neighbors(v);
			str += "\n";
		}
		
		return str;
	}
}