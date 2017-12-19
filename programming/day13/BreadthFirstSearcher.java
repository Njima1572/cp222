import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Interface for searching graphs
 */
public class BreadthFirstSearcher<N, W> implements ISearcher<N, W> {

    RingQueue<INode> queue;
    RingQueue<IEdge> edgeQueue;
    boolean pathFound;
    IList<INode<N>> pathNodes;
    IList<IEdge> pathEdges;


    public BreadthFirstSearcher(int size){
      pathNodes = new ArrayList<INode<N>>();
      pathEdges = new ArrayList<IEdge>();
      queue = new RingQueue(size);
      edgeQueue = new RingQueue(size);
    }
    /**
     * Determines if there is a path without returning the path
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return if a path of any length exists
     */
    public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
      // try{
      // Node node = (Node)s;
      // queue.enqueue(node);
      // while(!queue.isEmpty() && !pathFound){
      //     Node curr_node = (Node)queue.dequeue();
      //     Edge[] edgesFromNode = (Edge[])g.getEdgesFrom(curr_node);
      //     curr_node.visit();
      //     if(curr_node.getValue().equals(e.getValue())){
      //       pathFound = true;
      //       return pathFound;
      //     }
      //     System.out.println(curr_node.getValue());
      //     for(int i = 0; i < edgesFromNode.length; i++){
      //       Node dest_node = (Node)edgesFromNode[i].getDestination();
      //       System.out.println(curr_node.getValue() + " → " + dest_node.getValue());
      //
      //       if(!dest_node.getVisited()){
      //         queue.enqueue(dest_node);
      //
      //       }
      //     }
      // }
      // return pathFound;
      // }
      // catch(Exception ex){
      //   System.out.println(ex);
      //   return pathFound;
      // }
      helperGetPath(g, s, e);
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
      helperGetPath2(g, s, e);
      boolean backPath = false;
      int idx = 0;

      if(pathFound){
        Edge[] toE = (Edge[]) g.getEdgesTo(e);
        System.out.println(toE[0].getSource().getValue() + " ← " + toE[0].getDestination().getValue());

        for(int i = 0; i < toE.length; i++){
          if(toE[i].getVisited()){
            pathEdges.append(toE[i]);
          }
        }
        while(!backPath){
          Node curr_src = (Node)pathEdges.fetch(idx).getSource();
          if(curr_src.getValue().equals(s.getValue())){
            backPath = true;
          }
          Edge[] curr_src_src = (Edge[]) g.getEdgesTo(curr_src);
          for(int i = 0; i < curr_src_src.length; i++){
            if(curr_src_src[i].getVisited()){
              System.out.println(curr_src_src[i].getSource().getValue() + " ← " + curr_src_src[i].getDestination().getValue());
              pathEdges.append(curr_src_src[i]);
            }
          }
          idx++;
        }
      }
      for(int i = 0; i < pathEdges.size(); i++){
        System.out.println(pathEdges.fetch(i).getSource().getValue() + " → " + pathEdges.fetch(i).getDestination().getValue());

      }
      pathNodes = makeAndReverseNodeList(pathEdges);
      return pathNodes;
    }

    public IList<INode<N>> makeAndReverseNodeList(IList<IEdge> list){
      IList<INode<N>> nooodes = new ArrayList();
      nooodes.append(list.fetch(list.size() - 1).getSource());
      for(int i = list.size() - 1; i > -1; i--){
        nooodes.append(list.fetch(i).getDestination());
      }
      return nooodes;
    }


    public void helperGetPath(IGraph<N,W> g, INode<N> s, INode<N> e){
      try{
        Node node = (Node)s;
        queue.enqueue(node);
        while(!queue.isEmpty() && !pathFound){
            Node curr_node = (Node)queue.dequeue();
            Edge[] edgesFromNode = (Edge[])g.getEdgesFrom(curr_node);
            curr_node.visit();
            if(curr_node.getValue().equals(e.getValue())){
              pathFound = true;
              return;
            }
            for(int i = 0; i < edgesFromNode.length; i++){
              Node dest_node = (Node)edgesFromNode[i].getDestination();
              //System.out.println(curr_node.getValue() + " → " + dest_node.getValue());

              if(!dest_node.getVisited()){
                queue.enqueue(dest_node);

              }
            }
        }
        return;
      }
      catch(Exception ex){
        System.out.println(ex);
      }
    }

    public void helperGetPath2(IGraph<N,W> g, INode<N> s, INode<N> e){
      try{
        Edge[] edgesFromS = (Edge[]) g.getEdgesFrom(s);
        for(int i = 0; i < edgesFromS.length; i++){
          edgeQueue.enqueue(edgesFromS[i]);
        }
        while(!edgeQueue.isEmpty() && !pathFound){
          Edge curr_edge = (Edge)edgeQueue.dequeue();
          Node curr_edge_src = (Node)curr_edge.getSource();
          curr_edge_src.visit();
          curr_edge.visit();
          System.out.println(curr_edge.getSource().getValue() + " " + curr_edge.getDestination().getValue()); //This is null at this point.
          Node curr_dest = (Node)curr_edge.getDestination();

          if(curr_dest.getValue().equals(e.getValue())){
            pathFound = true;
            return;
          }

          Edge[] edgesFromCurr = (Edge[]) g.getEdgesFrom(curr_dest);
          for(int i = 0; i < edgesFromCurr.length; i++){
            Node dest = (Node)edgesFromCurr[i].getDestination();
            if(!dest.getVisited()){
              dest.visit();
              edgeQueue.enqueue(edgesFromCurr[i]);
            }
          }
        }
      }catch(Exception ex){
        System.out.println(ex);
      }
    }

    public static void main(String[] args) throws Exception{
      BreadthFirstSearcher bfs = new BreadthFirstSearcher(100);
      DiGraphReader r = new DiGraphReader();
      IGraph g = r.read("graphfile.cs2");
      INode[] nodeset = g.getNodeSet();
      //bfs.pathExists(g, nodeset[0], nodeset[nodeset.length - 2]);
      bfs.getPath(g, nodeset[0], nodeset[nodeset.length - 2]);
      for(int i = 0; i < bfs.pathNodes.size(); i++){
        Node noode = (Node)bfs.pathNodes.fetch(i);
        System.out.println(noode.getValue());
      }
    }
}
