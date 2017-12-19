import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Interface for searching graphs
 */
public class DepthFirstSearcher<N, W> implements ISearcher<N,W> {
    static boolean pathFound;
    IList<INode<N>> list = new ArrayList<INode<N>>();
    public DepthFirstSearcher(){
      pathFound = false;
    }
    /**
     * Determines if there is a path without returning the path
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return if a path of any length exists
     */
    public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
      helperGetPath(g, s, e);
      // while(!pathFound){
      //   Node node = (Node)s;
      //   IEdge[] edgesComingOut = g.getEdgesFrom(node);
      //
      //   for(int i = 0; i < edgesComingOut.length; i++){
      //     Edge edge = (Edge)edgesComingOut[i];
      //     Node noode = (Node)edgesComingOut[i].getDestination();
      //     System.out.println(edge.getSource().getValue() + " to " + edge.getDestination().getValue());
      //     if(e.getValue().equals(edge.getDestination().getValue())){
      //       System.out.println("found");
      //       pathFound = true;
      //       return pathFound;
      //     }
      //     if(pathFound){
      //       return pathFound;
      //     }
      //     if(!noode.getVisited()){
      //       noode.visit();
      //       pathExists(g, edge.getDestination(), e);
      //     }
      //   }
      // }
      return pathFound;
    }


    /**
     * Finds a path based on the properties of the search algorithm.
     * If there is no path in graph g from node s to node e, null should be
     * returned. If node s and node e are the same, an empty list should be returned.
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return the list of nodes in the path
     */
    public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
      IList<INode<N>> list = new ArrayList<INode<N>>();
      helperGetPath(g, s, e);
      INode[] nodes = g.getNodeSet();
      for(int i = 0; i < nodes.length; i++){
        Node node = (Node) nodes[i];
        if(node.getVisited()){
          list.append(nodes[i]);
        }
      }
      return list;
    }

    public void helperGetPath(IGraph<N, W> g, INode<N> s, INode<N> e){
      while(!pathFound){
        Node node = (Node)s;
        IEdge[] edgesComingOut = g.getEdgesFrom(node);
        node.visit();

        for(int i = 0; i < edgesComingOut.length; i++){
          Edge curr_edge = (Edge)edgesComingOut[i];
          Node curr_dest = (Node)edgesComingOut[i].getDestination();
          System.out.println(curr_edge.getSource().getValue() + " → " + curr_dest.getValue());
          curr_edge.visit();

          if(e.getValue().equals(curr_edge.getDestination().getValue())){
            pathFound = true;
            Node end = (Node)e;
            end.visit();
            return;
          }
          if(!pathFound){
            if(!curr_dest.getVisited()){
              curr_dest.visit();
              helperGetPath(g, curr_edge.getDestination(), e);
            }
            return;
          }
        }
      }
    }

    public static void main(String[] args) throws Exception{
      DiGraphReader r = new DiGraphReader();
      IGraph g = r.read("graphfile.cs2");
      DepthFirstSearcher d = new DepthFirstSearcher();
      INode[] nodeset = g.getNodeSet();
      System.out.println(d.pathExists(g, nodeset[0], nodeset[nodeset.length - 2]));
      ArrayList<Node<String>> path = (ArrayList)d.getPath(g, nodeset[0], nodeset[nodeset.length - 2]);
      for(int i = 0; i < path.size(); i++){
        System.out.println(path.fetch(i).getValue());

      }

    }
}
