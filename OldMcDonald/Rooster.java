
/**
 * A Rooster has a common name, Latin name, type, and sound.
 * 
 * @author Joshua Zhou
 * @version November 9, 2018
 */
public class Rooster extends Chicken
{
    /**
     * Constructs an object in the Rooster class.
     */
    public Rooster()
    {
        super("rooster");
    }
    
    /**
     * Gives the sound of the rooster.
     * 
     * @return  the sound of the rooster
     */
    @Override
    public String speak()
    {
        return "cock-a-doodle-do";
    }
}
