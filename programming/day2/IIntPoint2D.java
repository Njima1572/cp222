/**
 * An interface describing a representation of integer points on a 2D plane.
 */ 
public interface IIntPoint2D {
    /**
     * @returns the X coordinate
     */
    public int getX();
    /**
     * @returns the Y coordinate
     */
    public int getY();
    
    /**
     * Computes the manhattan distance to another point. 
     * formula: abs(x1-x2) + abs(y1-y2)
     * @param o the other point
     * @returns the manhattan distance
     */
    public int manhattanDistance(IIntPoint2D o);
    /**
     * Computes the euclidean distance to another point. 
     * formula: sqrt((x1-x2)^2 + (y1-y2)^2)
     * @param o the other point
     * @returns the euclidean distance
     */
    public double distance(IIntPoint2D o);
    
    // The following methods make JAVA objects better behaved
    /**
     * Converts a point object to a string of the form (X,Y)
     * @returns human friendly point representation
     */
    public String toString();
    /**
     * Determines if this point is the same as another (i.e. x1=x2 and y1=y2)
     * @returns true if this point is the same as point o
     */
    public boolean equals(Object o);
    /**
     * Hashcode to support some standard library data structures
     * formula: (x<<16)+y
     * @returns the hashcode for the point
     */
    public int hashcode();
}