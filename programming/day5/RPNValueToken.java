/**
 * Token representing a calculator value
 */
public class RPNValueToken implements RPNToken {
    Double value;
    
    /**
     * Constructs a token for the value
     * @param v the value to add to the stack
     */
    public RPNValueToken(Double v) {
        value = v;
    }
    
    /**
     * Pushes a value on to the stack
     * @param m the stack containing values
     */
    public void execute(IStack m) {
        try {
            IStack<Double> mem=(IStack<Double>)m;
            mem.push(value);
        } catch (OverFlowException err) {
            System.err.println("Couldn't push operand... "+value);
        }
    }
}