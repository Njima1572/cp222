/**
 * Token representing a calculator operation
 */
public class RPNOpToken implements RPNToken {
    char op;
    
    /**
     * Constructs a token for the operation
     * @param op the character representing the operation
     * @throws UnknownOpException if the <i>op</i> isn't a known operation character
     */
    public RPNOpToken(char op) throws UnknownOpException {
        switch(op) {
            case '+':
            case '-':
            case '*':
            case 'x':
            case '/':
                this.op=op;
                break;
            default:
                throw new UnknownOpException();
        }
    }
    
    /**
     * Executes the operation on the top stack operands
     * @param m the stack containing values
     */
    public void execute(IStack m) {
        try {
        IStack<Double> mem=(IStack<Double>)m;
        Double b = mem.pop();
        Double a = mem.pop();
        Double r=0.0;
        switch(op) {
            case '+':
                r = a+b;
                break;
            case '-':
                r = a-b;
                break;
            case '*':
            case 'x':
                r = a*b;
                break;
            case '/':
                r = a/b;
                break;
        }
        mem.push(r);
        } catch (UnderFlowException err) {
            System.err.println("Underflow when popping stack");
        } catch ( OverFlowException err) {
            System.err.println("Overflow when pushing answer");
        }
    }
}
