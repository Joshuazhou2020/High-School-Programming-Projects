
/**
 * An Equilateral Triangle has a name and three valid side lengths that are nearly equal.
 * 
 * @author Joshua Zhou
 * @version November 1, 2018
 */
public class Equilateral extends Triangle
{
    /**
     * Constructs an object of the Equilateral class.
     * 
     * @param   name    the name of the Equilateral
     * @param   leg     the length of the leg
     */
    public Equilateral(String name, double leg)
    {
        super(name, leg, leg, leg);
    }
    
    /**
     * Sets the length of one leg.
     * 
     * @param   leg     the length of the leg
     */
    @Override
    public void setSideA(double leg)
    {
        orderSides(leg, leg, leg);
    }
    
    /**
     * Sets the length of another leg.
     * 
     * @param   leg     the length of the leg
     */
    @Override
    public void setSideB(double leg)
    {
        setSideA(leg);
    }
    
    /**
     * Sets the length of the last leg.
     * 
     * @param   leg     the length of the leg
     */
    @Override
    public void setSideC(double leg)
    {
        setSideB(leg);
    }
}