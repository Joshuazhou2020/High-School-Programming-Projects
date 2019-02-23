/**
 * A Rectangle has a name, width, and length.
 * Area and perimeter can be calculated.
 * 
 * @author Joshua Zhou
 * @version November 1, 2018
 */
public class Rectangle extends Polygon
{
    private double length;
    private double width;
    
    /**
     * Constructs an object of the Rectangle class.
     * 
     * @param   name    the name of the Rectangle
     * @param   len     the length of the length
     * @param   wid     the length of the width
     */
    public Rectangle(String name, double len, double wid)
    {
        super(name);
        setLength(len);
        setWidth(wid);
    }
    
    /**
     * Gets the length of the Rectangle.
     * 
     * @return  the length of the Rectangle
     */
    public double getLength()
    {
        return length;
    }
    
    /**
     * Gets the width of the Rectangle.
     * 
     * @return  the width of the Rectangle
     */
    public double getWidth()
    {
        return width;
    }
    
    /**
     * Sets the length of the length of the Rectangle.
     * 
     * @param   len     the length of the length
     * 
     * @throw   IllegalArgumentException if the length is not positive
     */
    public void setLength(double len)
    {
        if(len<=0.0)
        {
            throw new IllegalArgumentException("Length is not legal for a rectangle");
        }
        length=len;
    }
    
    /**
     * Sets the width of the length of the Rectangle.
     * 
     * @param   wid     the length of the length
     * 
     * @throw   IllegalArgumentException if the width is not positive
     */    
    public void setWidth(double wid)
    {
        if(wid<=0.0)
        {
            throw new IllegalArgumentException("Width is not legal for a rectangle");
        }
        width=wid;
    }
    
    /**
     * Gets the perimeter of the Rectangle.
     * 
     * @return  the sum of the side lengths
     */
    @Override
    public double getPerimeter()
    {
        return 2*(length+width);
    }
    
    /**
     * Gets the area of the Rectangle.
     * 
     * @return  the area of the Rectangle
     */
    @Override
    public double getArea()
    {
        return length*width;
    }
    
    /**
     * Formats the information about the rectangle.
     * 
     * @return formatted information about the rectangle
     */
    @Override
    public String toString()
    {
        String str = "\n\t\t\twidth = %8.5f\tlength = %8.5f" +
                     "\n\t\t\tregular: %b\tside count = %d";
        return super.toString() +
               String.format( str,
                              getWidth(),
                              getLength(),
                              isRegular(),
                              numSides());
    }
    
    /**
     * Compares current Rectangle with the Object obj.
     * 
     * @param   obj Rectangle object with which to compare
     * 
     * @return  0   if the two rectangles have the same side lengths.
     *        > 0   if the lengths or widths of the rectangles are not nearly equal,
     *              and the length or width of the object is greater than that of
     *              the current rectangle
     *        < 0   if the lengths or widths of the rectangles are not nearly equal,
     *              and the length or width of the object is less than that of
     *              the current rectangle
     *       -999   if obj is not a Rectangle
     */
    @Override
    public int compareTo(Object obj)
    {
        if( obj instanceof Rectangle)
        {
            Rectangle rect=(Rectangle) obj;
            if(this.equals(rect))
            {
                return 0;
            }
            Double l=this.getLength();
            Double w=this.getWidth();
            Double rectL=rect.getLength();
            Double rectW=rect.getWidth();
            if(!isNearlyEqual(l,rectL))
            {
                if(l<rectL)
                {
                    return -1;
                }
                return 1;
            }
            if(!isNearlyEqual(w,rectW))
            {
                if(w<rectW)
                {
                    return -1;
                }
                return 1;
            }
        }
        return -999;
    }
    
    /**
     * Checks if the side lengths of obj and the Rectangle are nearly equal.
     * 
     * @param   obj     an object to be compared to Rectangle
     * 
     * @return  true    if obj and the Rectangle are equal; otherwise,
     *                  false
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Rectangle)
        {
            Rectangle rect = (Rectangle) obj;
            Double l = this.getLength();
            Double w = this.getWidth();
            Double rectL = rect.getLength();
            Double rectW = rect.getWidth();
            if(isNearlyEqual(l, rectL))
            {
                if(isNearlyEqual(w, rectW))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Gets the number of sides in a rectangle.
     * 
     * @return  the number of sides
     */
    @Override
    public int numSides()
    {
        return 4;
    }
    
    /**
     * Checks if the width and length of the rectangle are nearly equal.
     * 
     * @return  true    if the width and length are nearly equal; otherwise,
     *                  false
     */
    @Override
    public boolean isRegular()
    {
        return isNearlyEqual(length,width);
    }
}