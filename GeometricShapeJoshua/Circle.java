/**
 * A circle object has a radius that is valid.
 * Perimeter and area can be calculated. Comparable's
 * method compareTo compares two radii.
 * 
 * @author Joshua Zhou
 * @version October 25, 2018
 */
public class Circle extends GeometricShape
{
    // instance variables - replace the example below with your own
    private double radius;
    
    /**
     * Constructor for objects of class Circle.
     * 
     * @param name name of the circle
     * @param r    radius
     * 
     * @throws IllegalArgumentException if r is less than or equal to 0
     */
    public Circle(String name, double r)
    {
        super(name);
        setRadius(r);
    }

    /**
     * Constructor for unit circle object of the class Circle.
     * "this" circle has a radius of length one.
     * 
     * @param name name of the circle
     */
    public Circle(String name)
    {
        this(name,1.0);
    }
    
    /**
     * Gets the radius of the circle.
     * 
     * @return  the radius of the circle
     */
    public double getRadius()
    {
        return radius;
    }
    
    /**
     * Sets the length of the radius.
     * 
     * @param r the length of th enew radius and r>0
     * @throws IllegalArgumentException if radius is <=0
     */
    public void setRadius(double r)
    {
        if(r<=0.0)
        {
            throw new IllegalArgumentException("Radius needs to be positive");
        }
        radius=r;
    }
    
    /**
     * Calculates the perimeter.
     * 
     * @return the perimeter of the circle
     */
    @Override
    public double getPerimeter()
    {
        return 2.0*Math.PI*radius;
    }
    
    /**
     * Calculates the area.
     * 
     * @return the area of the circle
     */
    @Override
    public double getArea()
    {
        double r=getRadius();
        return Math.PI*r*r;
    }
    
    /**
     * Tests if the two circles have radii that are equal,
     * within an EPSILON, which is defined in GeometricShape.
     * 
     * @param   obj     Circle object to test if its radius is "nearly equal"
     *                  to "this" radius
     * @return  true    if the radii have "nearly equal" lengths; otherwise,
     *          false
     */
    @Override
    public boolean equals(Object obj)
    {
        return this.compareTo(obj)==0;        
    }
    
    /**
     * Compares current circle with the Object obj.
     * 
     * @param   obj Circle object with which to compare
     * @return  0   if the two circles have the same radii within
     *              an EPSILON, which is deined in GeometricShape
     *        > 0   if "this" radius > than obj's radius
     *        < 0   if "this" radius < than obj's radius
     *        -999  if obj is not a circle
     */
    @Override
    public int compareTo(Object obj)
    {
        if(obj instanceof Circle)
        {
            Circle circ=(Circle)obj;
            double thisRad=this.getRadius();
            double circRad=circ.getRadius();
            if(isNearlyEqual(thisRad,circRad))
                return 0;
            else if(thisRad>circRad)
                return 1;
            else
                return -1;
        }
        else
            return -999;
    }
    
    /**
     * Checks if the circle is a polygon.
     * 
     * @return  true    if the circle is a polygon; otherwise,
     *                  false
     */
    @Override
    public boolean isPolygon()
    {
        return false;
    }
    
    /**
     * Formats the class name, circle's name, area, perimeter, and radius.
     * 
     * @return  formatted information about the circle
     */
    @Override
    public String toString()    
    {
        return super.toString ( ) +
               String.format ("\n\t\t\tradius=%10.5f",this.getRadius()); 
    }
}