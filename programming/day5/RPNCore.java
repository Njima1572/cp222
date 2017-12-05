/**
 * This class implements the core logic for a RPN calculator
 */
public class RPNCore {
    /**
     * Computes a value by processing the queue and mutating the stack
     * @param in Queue of RPN tokens to process
     * @param mem Stack to use for processing
     * @throws BadExpressionException if the computation doesn't consume all values
     */
    public void compute(IQueue<RPNToken> in, IStack<Double> mem) throws BadExpressionException {
        RPNToken t;
        try {
            // dequeue all the things
            while((t=in.dequeue())!=null) {
                t.execute(mem);
            }
        } catch (UnderFlowException err) {
            // End of queue reached
        }

        // Verify that there is only one item in the stack
        Double answer = 0.0;
        try {
            answer = mem.pop();
            mem.pop(); // should throw an UnderFlowException
            mem.push(answer);
            throw new BadExpressionException();
        } catch (UnderFlowException err) {
            try {
                mem.push(answer);
            } catch (OverFlowException err2) {
                // this should never happen
                System.err.println("Something impossible occurred!");
            }
        } catch (OverFlowException err) {
            // this should never happen
            System.err.println("Something impossible occurred!");
        }
    }
}
