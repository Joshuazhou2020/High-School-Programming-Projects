
/**
 * A Pig has a Latin name, common name, and a sound.
 * 
 * @author Joshua Zhou
 * @version November 9, 2018
 */
public class Pig extends Animal
{
    /**
     * Constructs an object in the Pig class.
     */
    public Pig()
    {
        super("sus","pig");
    }
    
    /**
     * Gives the sound of the pig.
     * 
     * @return  the sound of the pig
     */
    @Override
    public String speak()
    {
        return "oink";
    }
}
