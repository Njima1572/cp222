/**
 * Interface for a stack implementation
 */
public interface IStack<T> {
    /**
     * Pushes a new value onto the stack
     * @param v the value to push
     */
    public void push(T v) throws OverFlowException;
    
    /**
     * Pops the top value from the stack
     * @return the value
     */
    public T pop() throws UnderFlowException;
}