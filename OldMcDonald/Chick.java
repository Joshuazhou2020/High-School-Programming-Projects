
/**
 * A Chick has a Latin name, common name, type, and sound.
 * 
 * @author Joshua Zhou
 * @version November 9, 2018
 */
public class Chick extends Chicken
{
    /**
     * Constructs an object in the Chick class.
     */
    public Chick()
    {
        super("chick");
    }
    
    /**
     * Gives the sound of the chick.
     * 
     * @return  the sound of the chick
     */
    @Override
    public String speak()
    {
        return "peep";
    }
}
