/**
 * An IsoscelesRightTriangle has a name, two equal sides, and a right angle.
 * 
 * @author Joshua Zhou
 * @version November 1, 2018
 */
public class IsoscelesRightTriangle extends Triangle
{
    /**
     * Constructor for objects of class IsocelesRightTriangle.
     * 
     * @param   name    name of the triangle, probably vertices
     * @param   leg     side length of the triangle's identical side lengths
     */
    public IsoscelesRightTriangle(String name, double leg)
    {
        super(name, leg*Math.sqrt(2.0),leg,leg);
    }
    
    /**
     * Sets the length of the hypotenuse and recalculates
     * the side lengths.
     * 
     * @param   hypotenuse  the length of the hypotenuse of
     *                      the right triangle
     */
    @Override
    public void setSideA(double hypotenuse)
    {
        double side=hypotenuse*Math.sqrt(0.5);
        orderSides(hypotenuse,side,side);
    }
    
    /**
     * Sets the length of the two equivalent sides and 
     * recalculates the hypotenuse.
     * 
     * @param   leg     the length of one of the legs of the isosceles
     *                  right triangle
     */
    @Override
    public void setSideB(double leg)
    {
        orderSides(leg*Math.sqrt(2.0),leg,leg);
    }
    
    /**
     * Sets the length of the two equivalent sides and 
     * recalculates the hypotenuse.
     * 
     * @param   leg     the length of one of the legs of the isosceles
     *                  right triangle
     */
    @Override
    public void setSideC(double leg)
    {
        setSideB(leg);
    }
}