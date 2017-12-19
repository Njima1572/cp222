/**
 * Interface for searching graphs
 */
public interface ISearcher<N,W> {
    /**
     * Determines if there is a path without returning the path
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return if a path of any length exists
     */
    public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e);
    
    /**
     * Finds a path based on the properties of the search algorithm.
     * If there is no path in graph g from node s to node e, null should be 
     * returned. If node s and node e are the same, an empty list should be returned.
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return the list of nodes in the path
     */
    public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e);
}