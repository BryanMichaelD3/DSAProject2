import java.util.Scanner;
import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class DSAProject2
{
	// Checks if the user input a valid jar problem
	public static boolean checkInput(int a, int b, int c)
	{
		// Checks if 'a' is an even value; if not, print an error message
		if(a % 2 != 0)
		{
			System.out.println("Error: The value of 'a' needs to be an even integer.\n");
			return false;
		}
		
		// Checks if 'b' is greater than or equal to half of 'a'; if not, print an error message
		if(b < a / 2)
		{
			System.out.println("Error: The value of 'b' needs to be greater than or equal to half the value of 'a'.\n");
			return false;
		}
		
		// Checks if 'a' is greater than or equal to 'b' which is greater than or equal to 'c' which is greater than 0; 
		// if not, print an error message
		if(a < b || b < c || c <= 0)
		{
			System.out.println("Error: The value of 'a' needs to be greater than or equal to the value of 'b' which needs \n"
					         + "       to be greater than or equal to the value of 'c' which needs to be greater than 0.\n");
			return false;
		}
		
		// If everything checks out all right, then the problem is valid
		return true;
	}
	
	// Creates a graph of the user's given jar problem
	public static Graph<Node> createGraph(int maxA, int maxB, int maxC)
	{
		Graph<Node> graph = new Graph<>();				// Graph of nodes representing jars
		Deque<Node> vertexQueue = new ArrayDeque<>();	// Queue of nodes that need to be iterated through to check for adjacent nodes
		
		// Add starting vertex to queue
		vertexQueue.addLast(new Node(maxA, 0, 0));
		
		// While the vertex queue is not empty...
		while(!vertexQueue.isEmpty())
		{
			// Take a node out of the queue and get a list of its adjacent nodes
			Node currentNode = vertexQueue.removeFirst();
			List<Node> adjacentNodes = currentNode.getAdjacentNodes(maxA, maxB, maxC);
			
			// If any of the adjacent nodes aren't in the graph yet, add them to the queue
			for(Node n: adjacentNodes)
			{
				boolean inGraph = false;	// Represents whether the current node is in the graph already or not
				
				for(Node v: graph)
				{
					if (v == n)
					{
						inGraph = true;
					}
				}
				
				if(!inGraph)
				{
					vertexQueue.addLast(n);
				}
			}
			
			// Add current node and its adjacency list to graph
			graph.add(currentNode);
			
			for(Node n: adjacentNodes)
			{
				graph.addEdge(currentNode, n);
		
			}
		}
		
		// Return the graph
		return graph;
	}
	
	public static void main(String[] args) 
	{
		int a = 0; // \
		int b = 0; // - Maximum capacity of jugs
		int c = 0; // /
		Scanner scan = new Scanner(System.in); // Scanner for input

		// Ask user for jug sizes while input is invalid,
		// prints error message if input is invalid
		do
		{
			System.out.println("-- Enter in the capacities of the jugs --");
			System.out.print("Enter a: ");
			a = scan.nextInt();
			System.out.print("Enter b: ");
			b = scan.nextInt();
			System.out.print("Enter c: ");
			c = scan.nextInt();
			System.out.println();
		} while(checkInput(a, b, c) == false);
		
		scan.close();
		
		System.out.println("It worked.");
/*
		// Create graph of jugs
		Graph jugs = createGraph(a, b, c);

		// Determine if (a/2, a/2, 0) is possible, if so then return string with shortest path
		String result = determinePaths(jugs);

		// Print out result
		System.out.println(result);
*/
	}
}