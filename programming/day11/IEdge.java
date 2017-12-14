/**
 * Interface for an edge in a graph. Edges are immutable.
 */
public interface IEdge<N,W> {
    // Implementors should implement a construct that takes in the 
    // source, destination, and weight
    
    /**
     * The source node of the edge
     * @return the source node
     */
    public INode<N> getSource();
    
    /**
     * The destination node of the edge
     * @return the destination node
     */
    public INode<N> getDestination();
    
    /**
     * The weight of the edge
     * @return the weight
     */
    public W getWeight();
    
    /**
     * Test for equality of two edges.
     * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
     * and this.dst == o.dst
     * @param o the other edge
     * @return true if the edges are the same
     */
    public boolean equals(Object o);
}