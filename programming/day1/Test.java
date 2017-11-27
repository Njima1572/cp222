/**
 * A basic set of test cases for IntPoint2D objects
 */
public class Test {
    /**
     * Runs a short test suite for IntPoint2D objects. Results must be manually reviewed.
     */
    public static void main(String[] argv) {
        // Make 3 point instances
        IntPoint2D a = new IntPoint2D(0,0);
        IntPoint2D b = new IntPoint2D(10,0);
        IntPoint2D c = new IntPoint2D(1,1);
        IntPoint2D d = new IntPoint2D(1,1);
        
        // Verify that the points have the expected values
        System.out.println("Do the points have expected values?");
        System.out.println("a should be (0,0)  -> "+a);
        System.out.println("b should be (10,0) -> "+b);
        System.out.println("c should be (1,1)  -> "+c);
        System.out.println("d should be (1,1)  -> "+d);
        
        // Verify that getX and getY are working
        System.out.println("\nAre getX() and getY() working?");
        System.out.println("b.x, b.y should be 10, 0 -> "+b.getX()+", "+b.getY());
        
        // Check the manhattan distance
        System.out.println("\nAre the manhattan distances working?");
        System.out.println("a to b should be 10 -> "+a.manhattanDistance(b));
        System.out.println("b to a should be 10 -> "+b.manhattanDistance(a));
        System.out.println("a to c should be  2 -> "+a.manhattanDistance(c));
        System.out.println("b to c should be 10 -> "+b.manhattanDistance(c));
        
        // Check the euclidean distance
        System.out.println("\nAre the euclidean distances working?");
        System.out.println("a to b should be 10 -> "+a.distance(b));
        System.out.println("b to a should be 10 -> "+b.distance(a));
        System.out.println("a to c should be roughly 1.4142 -> "+a.distance(c));
        
        // Check the equality function
        System.out.println("\nDo the equality checks work?");
        System.out.println("a==c should be false -> "+a.equals(c));
        System.out.println("c==a should be false -> "+c.equals(a));
        System.out.println("c==d should be true -> "+c.equals(d));
        
        // Check the hashcode function
        System.out.println("hashcode(a) should be 0      -> "+a.hashcode());
        System.out.println("hashcode(b) should be 655360 -> "+b.hashcode());
        System.out.println("hashcode(c) should be 65537  -> "+c.hashcode());
        System.out.println("hashcode(d) should be 65537  -> "+d.hashcode());
        
        return;
    }
}
        