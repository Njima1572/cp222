/**
 * Interface for a node in a graph. Nodes may have their values changed
 */
public interface INode<N> {
    // Implementors should provide a constructor that takes in a single argument, the
    // value for the node to initially hold.
    
    /**
     * Updates the value at the node
     * @param v new value
     */
    public void setValue(N v);
    
    /**
     * Fetches the value at the node
     * @return the current value
     */
    public N getValue(); 
     
     
    // No equals method should be implemented for Nodes since nodes are only equal if 
    // they are exactly the same instance (which is the default behavior for objects 
    // in java.
}