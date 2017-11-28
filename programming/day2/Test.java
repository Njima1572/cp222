/**
 * A basic set of test cases for IntGrid2D objects
 */
public class Test {
    /**
     * Runs a short test suite for IntGrid2D objects. Results must be manually reviewed.
     */
    public static void main(String[] argv) {
        // Make a new 3x3 grid with the center point at (0,0)
        // The IntGrid2D constructor takes in 5 arguments:
        //      upper left x
        //      upper left y
        //      lower right x
        //      lower right y
        //      a fill value for all grid cells
        IntGrid2D ttt = new IntGrid2D(-1,1,1,-1,' ');
        
        IIntPoint2D p1 = new IntPoint2D(0,0);
        ttt.setPoint(p1,'X');
        IIntPoint2D p2 = new IntPoint2D(1,1);
        ttt.setPoint(p2,'O');
        IIntPoint2D p3 = new IntPoint2D(-1,-1);
        ttt.setPoint(p3,'X');

        // print out the expected board        
        System.out.println("Board should look like:");
        System.out.println(" | |O");
        System.out.println("-+-+-");
        System.out.println(" |X| ");
        System.out.println("-+-+-");
        System.out.println("X| | ");
        
        // print out the actual board
        System.out.println("Board looks like:");
        for(int y=1;y>-2;y--) {
            IIntPoint2D c1 = new IntPoint2D(-1,y);
            IIntPoint2D c2 = new IntPoint2D(0,y);
            IIntPoint2D c3 = new IntPoint2D(1,y);
            System.out.println(ttt.getPoint(c1)+"|"+ttt.getPoint(c2)+"|"+ttt.getPoint(c3));
            if(y>-1) {
                System.out.println("-+-+-");
            }
        }
        
        // print out the corners
        System.out.println("upper left should be (-1,1) -> "+ttt.getUpperLeftCorner());
        System.out.println("lower right should be (1,-1) -> "+ttt.getLowerRightCorner());
        
        return;
    }
}
        