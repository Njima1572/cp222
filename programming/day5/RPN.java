/**
 * The Reverse Polish Notation Calculator program
 */
public class RPN {
    public static void main(String[] argv) {
        if(argv.length==0) {
            System.out.println("Usage: java RPN <token> ...");
            return;
        }
        IQueue<RPNToken> tokens = new RingQueue<RPNToken>(100);
        IStack<Double> stack  = new LinkStack<Double>(100);
        RPNCore core  = new RPNCore();

        for(int i=0; i<argv.length; i++) {
            try {
                Double v = new Double(argv[i]);
                tokens.enqueue(new RPNValueToken(v));
            } catch (NumberFormatException err) {
                if(argv[i].length()>1) {
                    System.err.println("Bad operator value: "+argv[i]);
                    return;
                }
                try {
                    tokens.enqueue(new RPNOpToken(argv[i].charAt(0)));
                } catch (UnknownOpException err2) {
                    System.err.println("Bad operator value: "+argv[i]);
                    return;
                } catch (OverFlowException err2) {
                    System.err.println("Too many arguments.");
                    return;
                }
            } catch (OverFlowException err) {
                System.err.println("Too many arguments.");
                return;
            }
        }

        try {
            core.compute(tokens, stack);
            System.out.println("Answer is: "+stack.pop());
        } catch (UnderFlowException err) {
            System.err.println("Stack is somehow empty");
        } catch (BadExpressionException err) {
            System.err.println("Expression was incomplete.");
        }
    }
}
