# DSAProject2

This Java program is meant to solve the general jug math problem, in which there are three jugs a, b, and c with a whole number capacity. The goal of the program is to pour the jugs into the other jugs in a valid way to ultimately leaves us with three jugs that hold (a/2, a/2, 0). When pouring from one jug to another, you must pour until the jug is empty or until the receiving jug is filled to capacity. If there is a solution to the problem, then the program will display the shortest path from (a, 0, 0) to (a/2, a/2, 0). The program will also show how many vertices and edges are in the graph. For the problem to be valid, a ≥ b ≥ c > 0, and b ≥ a/2, if the user inputs an invalid problem, an error message will be displayed and the program will ask for new input.

# Classes

DSAProject2 - This is the main class of the program which contains several methods. The class contains main(), a checkInput() method which is meant to check a ≥ b ≥ c > 0, and b ≥ a/2; a createGraph() method that creates a graph with the user's give input; a determinePath() method which helps us determine the shortest path from (a, 0, 0) to (a/2, a/2, 0); and a pathToString() method that reformats the path list and turns it into a formatted string.

Graph - This class is an implementation of the graph data structure. This class has a hasSolution() method that makes the program check if (a, 0, 0) has a solution of (a/2, a/2, 0). If there is a solution it returns true, else it returns false.

Node - This class holds three integer values representing how much is in each of the three jugs. This class contains a getAdjacentNodes() method that returns a list of all the adjecent node to the given node; and moveAtoB(), moveAtoC(), moveBtoA(), moveBtoC(), moveCtoA(), and moveCtoB() methods. These methods are used to pour from one jug to another; the methods also make sure the pours are valid pours and there is no overflow when pouring to another jug.
