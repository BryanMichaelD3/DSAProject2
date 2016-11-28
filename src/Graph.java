import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	@Override
	public Iterator<T> iterator()
	{
		return neighbors.keySet().iterator();
	}
}