DSAProject2

This Java program is meant to solve the jug problem, in which there is three jugs a, b, and c with a whole number capacity. The goal of the program is to pour the jugs into the other jugs in a valid way to ultimately leaves us with three jugs that hold (a/2, a/2, 0). If there is a solution for the problem, then the program will display the shortest path from (a,0,0) to (a/2,a/2,0). The program will also show a graph with all the vertices and the edges in the graph. For this program to work a ≥ b ≥ c > 0, and b ≥ a/2, if the user inputs an invalid input the an error will be displayed.

Classes

DSAProject2 - This is the main class of the programs which contains four methods. The class contains main(), a checkInput() method which is meant to check a ≥ b ≥ c > 0, and b ≥ a/2; a createGraph() method that creates a graph with the user's give input; a determinePath() method which helps us determine the shortes path from (a,0,0) to (a/2,a/2,0); and a pathToString() method that reformats the path list and turns it into a displayable string.

Graph - This class is an implementation of the graph data structure. This class has a hasSolution() method that makes the program check if (a, 0, 0) has a solution of (a/2, a/2, 0). If there is a solution it resturns true, else is false.

Node - This class holds three integer values representing how much is in each of the three jugs. This class contains a getAdjacentNodes() method that return a list of all the adjecent node to the given node; and a moveAtoB(), moveAtoC(), moveBtoA(), moveBtoC(), moveCtoA(), and moveCtoB() methods. These methods are used to pour from one jug to another, the methods also make sure the pours are valid pours and there is no overflow when pouring to another jug. 
