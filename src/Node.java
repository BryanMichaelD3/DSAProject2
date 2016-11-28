import java.util.ArrayList;
import java.util.List;

public class Node 
{
	private int a;	// Jar a
	private int b;  // Jar b
	private int c;  // Jar c
	
	// Constructor
	public Node(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// Getters
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	// Setters
	public void setA(int value)
	{
		a = value;
	}
	
	public void setB(int value)
	{
		b = value;
	}
	
	public void setC(int value)
	{
		c = value;
	}
	
	// Returns a list of all the adjacent nodes to the given node
	public List<Node> getAdjacentNodes(int maxA, int maxB, int maxC)
	{
		List<Node> adjacentNodes = new ArrayList<>();		// List of adjacent nodes to the current vertex node
		Node newVertex = new Node(getA(), getB(), getC()); 	// Node representing the adjacent vertices of the method's original vertex
		
		// Move 'a' to 'b'
		newVertex.moveAtoB(maxA, maxB, maxC);

		// Add the new vertex to adjacency list if it's not identical to the starting vertex
		if(!newVertex.equals(this))
		{
			adjacentNodes.add(newVertex);
		}
		
		// Reset new vertex back to original vertex values for next adjacent case
		newVertex.setA(getA());
		newVertex.setB(getB());
		newVertex.setC(getC());
		
		// Move 'a' to 'c'
		newVertex.moveAtoC(maxA, maxB, maxC);

		// Add the new vertex to adjacency list if it's not identical to the starting vertex
		if(!newVertex.equals(this))
		{
			adjacentNodes.add(newVertex);
		}
		
		// Reset new vertex back to original vertex values for next adjacent case
		newVertex.setA(getA());
		newVertex.setB(getB());
		newVertex.setC(getC());

		// Move 'b' to 'a'
		newVertex.moveBtoA(maxA, maxB, maxC);

		// Add the new vertex to adjacency list if it's not identical to the starting vertex
		if(!newVertex.equals(this))
		{
			adjacentNodes.add(newVertex);
		}
		
		// Reset new vertex back to original vertex values for next adjacent case
		newVertex.setA(getA());
		newVertex.setB(getB());
		newVertex.setC(getC());
				
		// Move 'b' to 'c'
		newVertex.moveBtoC(maxA, maxB, maxC);

		// Add the new vertex to adjacency list if it's not identical to the starting vertex
		if(!newVertex.equals(this))
		{
			adjacentNodes.add(newVertex);
		}
		
		// Reset new vertex back to original vertex values for next adjacent case
		newVertex.setA(getA());
		newVertex.setB(getB());
		newVertex.setC(getC());
		
		// Move 'c' to 'a'
		newVertex.moveCtoA(maxA, maxB, maxC);

		// Add the new vertex to adjacency list if it's not identical to the starting vertex
		if(!newVertex.equals(this))
		{
			adjacentNodes.add(newVertex);
		}
		
		// Reset new vertex back to original vertex values for next adjacent case
		newVertex.setA(getA());
		newVertex.setB(getB());
		newVertex.setC(getC());
		
		// Move 'c' to 'b'
		newVertex.moveCtoB(maxA, maxB, maxC);

		// Add the new vertex to adjacency list if it's not identical to the starting vertex
		if(!newVertex.equals(this))
		{
			adjacentNodes.add(newVertex);
		}
		
		// Reset new vertex back to original vertex values for next adjacent case
		newVertex.setA(getA());
		newVertex.setB(getB());
		newVertex.setC(getC());
		
		return adjacentNodes;
	}
	
	// These methods are used to move values from one jar to another
	public void moveAtoB(int maxA, int maxB, int maxC)
	{
		// Move 'a' to 'b'
		setB(getB() + getA());
		setA(0);
		
		// If 'b' is now above capacity, move the overflow back to 'a'
		if(getB() > maxB)
		{
			int overflow = getB() - maxB;
			setB(maxB);
			setA(overflow);
		}
	}
	
	public void moveAtoC(int maxA, int maxB, int maxC)
	{
		// Move 'a' to 'c'
		setC(getC() + getA());
		setA(0);
		
		// If 'c' is now above capacity, move the overflow back to 'a'
		if(getC() > maxC)
		{
			int overflow = getC() - maxC;
			setC(maxC);
			setA(overflow);
		}
	}
	
	public void moveBtoA(int maxA, int maxB, int maxC)
	{
		// Move 'b' to 'a'
		setA(getA() + getB());
		setB(0);
		
		// If 'a' is now above capacity, move the overflow back to 'b'
		if(getA() > maxA)
		{
			int overflow = getA() - maxA;
			setA(maxA);
			setB(overflow);
		}
	}
	
	public void moveBtoC(int maxA, int maxB, int maxC)
	{
		// Move 'b' to 'c'
		setC(getC() + getB());
		setB(0);
		
		// If 'c' is now above capacity, move the overflow back to 'b'
		if(getC() > maxC)
		{
			int overflow = getC() - maxC;
			setC(maxC);
			setB(overflow);
		}
	}
	
	public void moveCtoA(int maxA, int maxB, int maxC)
	{
		// Move 'c' to 'a'
		setA(getA() + getC());
		setC(0);
		
		// If 'a' is now above capacity, move the overflow back to 'c'
		if(getA() > maxA)
		{
			int overflow = getA() - maxA;
			setA(maxA);
			setC(overflow);
		}		
	}
	
	public void moveCtoB(int maxA, int maxB, int maxC)
	{
		// Move 'c' to 'b'
		setB(getB() + getC());
		setC(0);
		
		// If 'b' is now above capacity, move the overflow back to 'c'
		if(getB() > maxB)
		{
			int overflow = getB() - maxB;
			setB(maxB);
			setC(overflow);
		}		
	}
}