/**
 * Interface for classes that due sorts
 */
public interface ISort<T extends Comparable> {
    /**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public  void sort(T[] in);
    
    /**
     * Produces the name of the kind of sort implemented
     * @return the name of the sort algorithm
     */
    public String sortName();
}