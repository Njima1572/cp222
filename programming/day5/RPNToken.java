/**
 * Token representing something the calculator knows how to handle
 */
public interface RPNToken<T> {
    /**
     * Executes the token using the stack
     * @param mem the stack containing values
     */
    public void execute(IStack<Double> mem);
}