import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Interface for classes that read graphs from files.
 */
public interface IGraphReader {
    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     * @throws FileNotFoundException if the file name is bogus
     * @throws IOException if there are problems reading the file
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException;
        
}