/**
 * The interface for the link cells in a singlely linked list to the one before.
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
     * Gets the previous cell in the list
     * @return the cell
     */
    public ISLink<T> getPrev();

    /**
     * Sets the previous cell in the list
     * @param c the next cell
     */
    public void setPrev(ISLink<T> c);

}
