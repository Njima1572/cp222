The files provided define an interface for a graph implementation. You will need to
implement the Graph, Node, and Edge classes. Additionally, you will need to implement
an IGraphReader that can read in a directed graph from a file. You are free to use any
of the data structures you have implemented this block to help with implementation of
your graph class.

The included graph file has three nodes and three edges. "node1" connects to "node2" with
an edge of weight 5.5, "node1" connects to "node3" with an edge of weight -0.2, and
"node2" connects to "node3" with a weight of 1.2.

Scaffold code for the class to read a graph from file has been provided. The value at
each node using the reader should be the String name of the node. Fill in the missing
logic for DiGraphReader.java; when the code is working you should get the following
output:
node1 -> node2  w: 5.5
node1 -> node3  w: -0.2
node2 -> node3  w: 1.2

Files:
IGraph.java - An interface for a graph implementation
INode.java  - An interface for nodes used by IGraph instances
IEdge.java  - An interface for edges used by IGraph instances
IGraphReader.java - An interface for classes that read in graphs
DiGraphReader.java - Reads out file in a form of "node1:node2:weight"
graphfile.cs2 - A sample graph file containing 3 nodes and 3 edges
Graph.java  - A class for a graph implements IGraph.java
Node.java  - A class for a node implements INode.java
Edge.java  - A class for an edge implements IEdge.java
