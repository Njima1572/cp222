import java.util.ArrayList;

/**
 * Interface for a directed graph data structure
 */
public class Graph<N, W> implements IGraph<N, W>{

    ArrayList<Node<N>> nodes;
    ArrayList<Edge<N, W>> edges;

    public Graph(){
      nodes = new ArrayList<Node<N>>();
      edges = new ArrayList<Edge<N, W>>();
    }
    /**
     * Gets an array of all the nodes in the graph
     * @return the node set
     */
    public INode<N>[] getNodeSet(){
      Node[] nodesArray = new Node[nodes.size()];
      for(int i = 0; i < nodes.size(); i++){
        nodesArray[i] = nodes.get(i);
      }
      return nodesArray;
    }

    /**
     * An array of the neighbors of a node
     * @param n the node
     * @return neighbors of n
     */
    public INode<N>[] getNeighbors(INode<N> n){
      Node[] neighborsArray = new Node[nodes.size()];
      ArrayList<Node<N>> neighbors = new ArrayList<Node<N>>();
      for(int i = 0; i < edges.size(); i++){
        if(edges.get(i).source.equals(n)){
          neighbors.add(edges.get(i).dest);
        }
        if(edges.get(i).dest.equals(n)){
          neighbors.add(edges.get(i).source);
        }
      }
      for(int i = 0; i < neighbors.size(); i++){
        neighborsArray[i] = neighbors.get(i);
      }
      return neighborsArray;
    }

    /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */
    public INode<N> addNode(N v){
      for(int i = 0; i < nodes.size(); i++){
        if(nodes.get(i).getValue().equals(v)){
          return nodes.get(i);
        }
      }
      Node newNode = new Node(v); //if there is a node already, then don't add.
      nodes.add(newNode);
      return newNode;
    }

    /**
     * Gets an array of all the edges in the graph
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgeSet(){
      Edge[] edgesArray = new Edge[edges.size()];
      for(int i = 0; i < edges.size(); i++){
        edgesArray[i] = edges.get(i);
      }
      return edgesArray ;
    }

    /**
     * Gets an array of all the edges sourced at a particular node
     * @param n the source node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesFrom(INode<N> n){
      ArrayList<Edge> temp = new ArrayList<Edge>();
      for(int i = 0; i < edges.size(); i++){
        if(edges.get(i).getSource().equals(n)){
          temp.add(edges.get(i));
        }
      }
      Edge[] edgesFrom = new Edge[temp.size()];

      for(int i = 0; i < temp.size(); i++){
        edgesFrom[i] = temp.get(i);
      }
      return edgesFrom;
    }

    /**
     * Gets an array of all the edges destined for a particular node
     * @param n the destination node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesTo(INode<N> n){
      ArrayList<Edge> temp = new ArrayList<Edge>();
      for(int i = 0; i < edges.size(); i++){
        if(edges.get(i).getDestination().getValue().equals(n.getValue())){
          temp.add(edges.get(i));
        }
      }
      Edge[] edgesTo = new Edge[temp.size()];
      for(int i = 0; i < temp.size(); i++){
        edgesTo[i] = temp.get(i);
      }
      return edgesTo;
    }


    /**
     * Adds an edge to the graph.
     * Duplicate edges are not allowed in the graph. The equals method of the edge can
     * be used to determine if two edges duplicate one another.
     * @param w weight of the edge
     * @param s source node
     * @param d destination node
     */
    public void addEdge(INode<N> s, INode<N> d, W w){
      Edge<N, W> newEdge = new Edge((Node)s, (Node)d, w);
      edges.add(newEdge);
    }
    /**
     * Adds two nodes and an edge between those Nodes.
     * @param v1 new source node
     * @param v2 new destination node
     * @param w weight for new edge
     */
    public void addTwoNodes(N v1, N v2, W w){
      Node n1 = (Node)addNode(v1);
      Node n2 = (Node)addNode(v2);
      addEdge(n1, n2, w);
    }
}
