
/**
 * Determines if two objects' quantifiable properties are close enough to each
 * other to be considered equal.
 * 
 * @author Joshua Zhou
 * @version October 23, 2018
 */
public interface Nearable
{
    /**
     * Determines if two objects' quantities are within an epsilon difference
     * of each other.
     * 
     * @param  obj1   an object to be tested as close to another object
     * @param  obj2   an object to be tested as close to another object
     * 
     * @return true   if the quantities are close to each other; otherwise,
     *         false
     */
    boolean isNearlyEqual(Object obj1, Object obj2);    //abstract: no code in body
}