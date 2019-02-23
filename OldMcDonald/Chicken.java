
/**
 * A Chicken has a Latin name, common name, type, and sound.
 * 
 * @author Joshua Zhou
 * @version November 9, 2018
 */
public class Chicken extends Animal
{
    /**
     * Constructs an object in the Chicken class.
     */
    public Chicken()
    {
        this("chicken");
    }
    
    /**
     * Constructs an object in the Chicken class with one parameters.
     * 
     * @param   chickenType     the type of chicken
     */
    public Chicken(String chickenType)
    {
        super("Gallus Gallus domesticus", chickenType);
    }
    
    /**
     * Gives the sound of the chicken.
     * 
     * @return  the sound of the chicken
     */
    @Override
    public String speak()
    {
        return "bawk";
    }
}