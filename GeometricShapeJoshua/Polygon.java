/**
 * Abstract class Polygon focuses on the polygon's
 * name and side number, and checks if it is a polygon
 * and if it is regular.
 * 
 * @author Joshua Zhou
 * @version November 1, 2018
 */
public abstract class Polygon extends GeometricShape
{
    /**
     * Constructs an object in the Polygon class.
     * 
     * @param   name    the name given to the Polygon
     */
    public Polygon(String name)
    {
        super(name);
    }
    
    /**
     * Checks if the Polygon is a polygon.
     * 
     * @return  true    if the Polygon is a polygon; otherwise,
     *                  false
     */
    @Override
    public boolean isPolygon()
    {
        return true;
    }
    
    /**
     * Checks if the Polygon is regular.
     * 
     * @return  true    if the Polygon is regular; otherwise,
     *                  false
     */
    public abstract boolean isRegular();
    
    /**
     * Gets the number of sides of a Polygon.
     * 
     * @return  the number of sides
     */
    public abstract int numSides();
}