/**
 * The interface for the link cells in a singlely linked list
 */
public interface ISLink<T> {
    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public T getValue();

    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(T v);

    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public ISLink<T> getNext();

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(ISLink<T> c);

}
