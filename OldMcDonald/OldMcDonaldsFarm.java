import java.util.ArrayList;
/**
 * Prints out the Old McDonald's Farm song with the animals' name and sound.
 * 
 * @author Joshua Zhou
 * @version November 9, 2018
 */
public class OldMcDonaldsFarm 
{
    private String farmerName;
    private ArrayList<Animal> farmAnimals;
    /**
     * Constructs an object in the OldMcDonaldsFarm class.
     */
    public OldMcDonaldsFarm()
    {
        farmerName = "Old MacDonald";
        farmAnimals = new ArrayList <Animal>();
    }

    /**
     * Prints the main verse of the song with the animals' name and sound.
     */
    public void singVerse()
    {
        String phrase1 = farmerName +  " had a farm,";
        String ei = " E-I-E-I-O";
        int i=0;
        System.out.println(phrase1+ei+". And on his farm he had some " 
            +farmAnimals.get(i+farmAnimals.size()-1).getCommonName()
            +"s,"+ei+".");
        for (int j=farmAnimals.size()-1;j>=0;j--)
        {
            System.out.println("With a "+farmAnimals.get(j).speak()+"-"  
                +farmAnimals.get(j).speak()+" here, and a "
                +farmAnimals.get(j).speak()+"-"  
                +farmAnimals.get(j).speak()+" there,");
            System.out.println("Here a " +farmAnimals.get(j).speak() + ", there a " 
                +farmAnimals.get(j).speak()
                +", every where a "+farmAnimals.get(j).speak()+"-"  
                +farmAnimals.get(j).speak()+",");
        }
        System.out.println(phrase1+ei+"."+"\n\n\n");
    }

    /**
     * Prints the song with the given animals.
     * 
     * @param   args    arguments from the command line
     */
    public static void main(String[] args)
    {
        OldMcDonaldsFarm singer=new OldMcDonaldsFarm();
        singer.farmAnimals.add(new Chicken());
        singer.singVerse();
        singer.farmAnimals.add(new Chick());
        singer.singVerse();
        singer.farmAnimals.add(new Rooster());
        singer.singVerse();
        singer.farmAnimals.add(new Pig());
        singer.singVerse();
    }
}
