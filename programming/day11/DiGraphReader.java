import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    String[] tokens;
    Node n1;
    Node n2;
    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
    }

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        // Open the file
        Graph<String, Double> graph = new Graph<String, Double>();
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        // Parse the lines. If a line does not have exactly 3 fields, ignore the line
        String l = bf.readLine();

        // For each line, add the nodes and edge

        while(l != null){
          tokens = l.split(":");
          Double weight = Double.parseDouble(tokens[2]);
          graph.addTwoNodes(tokens[0], tokens[1], weight);
          l = bf.readLine();
        }

        // Return the graph instance
        return graph;
    }

    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
        INode[] nodes = g.getNodeSet();
        for(int i = 0; i < nodes.length; i++){
          System.out.println(nodes[i].getValue());
        }
    }
}
