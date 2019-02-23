/**
 * A Triangle has a name and three side lengths that are valid.
 * Perimeter and area can be calculated.
 * 
 * @author Joshua Zhou
 * @version October 30, 2018
 */
public class Triangle extends Polygon
{
    private double sideA;
    private double sideB;
    private double sideC;
    
    /**
     * Constructor for objects of class Triangle.
     * 
     * @postcondition   sideA >= sideB >= sideC
     * 
     * @param   name    name of the triangle, probably vertices
     * @param   m       one of the side lengths of the triangle
     * @param   n       another of the side lengths of the triangle
     * @param   p       last of the side lengths of the triangle
     */
    public Triangle(String name, double m, double n, double p)
    {
        super(name);
        orderSides(m,n,p);
    }
    
    /**
     * Returns the length of the longest side.
     * 
     * @postcondition   sideA >= sideB >= sideC
     * 
     * @return  the length of the longest side
     */
    public double getSideA ()
    {
        return sideA;
    }
    
    /**
     * Returns the length of the middle side.
     * 
     * @postcondition   sideA >= sideB >= sideC
     * 
     * @return  the length of the middle side
     */
    public double getSideB ()
    {
        return sideB;
    }
    
    /**
     * Returns the length of the shortest side.
     * 
     * @postcondition   sideA >= sideB >=sideC
     * 
     * @return  the length of the shortest side
     */
    public double getSideC ()
    {
        return sideC;
    }
    
    /**
     * Gets the perimeter of the triangle.
     * 
     * @return  the sum of the side lengths
     */
    @Override
    public double getPerimeter()
    {
        return sideA+sideB+sideC;
    }
    
    /**
     * Gets the area of the triangle.
     * 
     * @return  the area of the triangle
     */
    @Override
    public double getArea()
    {
        double s=(getPerimeter())/2;
        return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
    }

    /**
     * Sets the length of the longest side.
     * 
     * @postcondition   sideA >= sideB >= sideC
     * 
     * @param   anotherA    the length of the modified sideA
     */
    public void setSideA (double anotherA)
    {
        orderSides(anotherA, sideB, sideC);
    }

    /**
     * Sets the length of the second to longest side.
     * 
     * @postcondition   sideA >= sideB >= sideC
     * 
     * @param   anotherB    the length of the modified sideB
     */
    public void setSideB (double anotherB)
    {
        orderSides(sideA, anotherB, sideC);
    }

    /**
     * Sets the length of the shortest side.
     * 
     * @postcondition   sideA >= sideB >= sideC
     * 
     * @param   anotherC    the length of the modified sideC
     */
    public void setSideC(double anotherC)
    {
        orderSides(sideA, sideB, anotherC);
    }
        
    /**
     * Order the side lengths so that sideA >= sideB >= sideC
     * 
     * @param   a   one of the side lengths of the triangle
     * @param   b   another of the side lengths of the triangle
     * @param   c   last of the side lengths of the triangle
     * 
     * @throws  IllegalArgumentException if sides do not make a valid triangle
     */
    public void orderSides(double a, double b, double c)
    {
        sideA = Math.max(a,Math.max(b,c));
        sideC = Math.min(a,Math.min(b,c));
        sideB = a+b+c-sideA-sideC;

        if (sideA>=sideB + sideC || sideC <=0)
        {
            throw new IllegalArgumentException("Invalid side lengths");
        }
    }
    
    /**
     * Checks if all sides of the object and the triangle are nearly equal.
     * 
     * @param   obj     an object to be compared to the triangle
     * 
     * @return  true    if the object and the triangle are equal; otherwise,
     *                  false
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Triangle)
        {
            Triangle tri = (Triangle) obj;
            Double a = this.getSideA();
            Double b = this.getSideB();
            Double c = this.getSideC();
            Double triA = tri.getSideA();
            Double triB = tri.getSideB();
            Double triC = tri.getSideC();
            if(isNearlyEqual(a, triA))
            {
                if(isNearlyEqual(b, triB))
                {
                    if(isNearlyEqual(c, triC))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Compares current triangle with the Object obj.
     * 
     * @param   obj Triangle object with which to compare
     * 
     * @return  0   if the two triangles have the same side length.
     *        > 0   determined by comparing the two longest sides;
     *              if equal, compare medium-length sides; and if equal, 
     *              compare the shortest side until current triangle has a
     *              longer length than obj's comparable length
     *        < 0   determined by comparing the twolongest sides. if equal,
     *              compare medium-length sides and
     *              if equal, compare the shorter length than the obj's comparable length,
     *       -999   if obj is not a Triangle
     */
    @Override
    public int compareTo(Object obj)
    {
        if (obj instanceof Triangle)
        {
            Triangle tri = (Triangle) obj;
            if (this.equals(tri))
            {
                return 0;
            }
            Double a = this.getSideA();
            Double b = this.getSideB();
            Double c = this.getSideC();
            Double triA = tri.getSideA();
            Double triB = tri.getSideB();
            Double triC = tri.getSideC();
            if (!isNearlyEqual(a,triA))
            {
                if (a<triA)
                {
                    return -1;
                }
                return 1;
            }
            if (!isNearlyEqual(b,triB))
            {
                if (b<triB)
                {
                    return -1;
                }
                return 1;
            }
            if (!isNearlyEqual(c,triC))
            {
                if (c<triC)
                {
                    return -1;
                }
                return 1;
            }
        }
        return -999;
    }    
    
    /**
     * Checks if the three sides of a triangle are nearly equal.
     * 
     * @return  true    if the triangle is regular; otherwise,
     *                  false
     */
    @Override
    public boolean isRegular()
    {
        if(isNearlyEqual(sideA, sideB))
        {
            if(isNearlyEqual(sideA, sideC))
            {
                if(isNearlyEqual(sideB, sideC))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Gets the number of sides of a triangle.
     * 
     * @return  the number of sides
     */
    @Override
    public int numSides()
    {
        return 3;
    }
    
    /**
     * Formats the trangle's class name, the object's name, and its perimeter and area.
     * 
     * @return  a formatted line about the geometric object
     */
    @Override
    public String toString()
    {
        String str = "\n\t\t\ta = %8.5f\tb = %8.5f\tc = %8.5f"+
            "\n\t\t\tregular: %b\tside count = %d";
        return super.toString() + String.format( str,
            getSideA(),
            getSideB(),
            getSideC(),
            isRegular(),
            numSides());
    }
}