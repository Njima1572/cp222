/**
 * Class for an edge in a graph. Edges are immutable.
 */
public class Edge<N,W> implements IEdge<N,W> {
    // Implementors should implement a construct that takes in the
    // source, destination, and weight
    Node<N> source;
    Node<N> dest;
    W weight;

    public Edge(Node a, Node b, W w){
      source = a;
      dest = b;
      weight = w;
    }

    /**
     * The source node of the edge
     * @return the source node
     */
    public INode<N> getSource(){
      return source;
    }

    /**
     * The destination node of the edge
     * @return the destination node
     */
    public INode<N> getDestination(){
      return dest;
    }

    /**
     * The weight of the edge
     * @return the weight
     */
    public W getWeight(){
      return weight;
    }

    /**
     * Test for equality of two edges.
     * Edges are equal when the node instances are exactly the same{} i.e. this.src==o.src
     * and this.dst == o.dst
     * @param o the other edge
     * @return true if the edges are the same
     */
    public boolean equals(Object o){
      Edge other = (Edge) o;
      if(this.source.equals(other.source)){
        if(this.dest.equals(other.dest)){
          return true;
        }
      }
      return false;
    }
}
