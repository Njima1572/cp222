/**
 * An interface for 2D grids that store char values
 */
public interface IIntGrid2D {

    /**
     * Sets the value at a point on the grid, replacing the previous value if any.
     * @param p The coordinate to set the value of
     * @param v The value to set at the coordinate
     */
    public void setPoint(IIntPoint2D p, char v);
    
    /**
     * Gets the value at a point on the grid
     * @param p The coordinate to get the value of
     * @returns the stored value
     */
    public char getPoint(IIntPoint2D p);
    
    /**
     * Gets the coordinate for the upper left most location
     * @returns an IIntPoint that is the coordinate of the upper left corner
     */
    public IIntPoint2D getUpperLeftCorner();
    
    /**
     * Gets the coordinate for the lower right most location
     * @returns an IIntPoint that is the lower right corner
     */
    public IIntPoint2D getLowerRightCorner();
    
}