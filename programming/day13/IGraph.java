/**
 * Interface for a directed graph data structure
 */
public interface IGraph<N, W> {
    /**
     * Gets an array of all the nodes in the graph
     * @return the node set
     */
    public INode<N>[] getNodeSet();
    
    /**
     * An array of the neighbors of a node
     * @param n the node
     * @return neighbors of n
     */
    public INode<N>[] getNeighbors(INode<N> n);
    
    /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */
    public INode<N> addNode(N v);
    
    /**
     * Gets an array of all the edges in the graph
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgeSet();
    
    /**
     * Gets an array of all the edges sourced at a particular node
     * @param n the source node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesFrom(INode<N> n);

    /**
     * Gets an array of all the edges destined for a particular node
     * @param n the destination node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesTo(INode<N> n);

    
    /**
     * Adds an edge to the graph.
     * Duplicate edges are not allowed in the graph. The equals method of the edge can
     * be used to determine if two edges duplicate one another.
     * @param w weight of the edge
     * @param s source node
     * @param d destination node
     */
    public void addEdge(INode<N> s, INode<N> d, W w);  
}