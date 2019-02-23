/**
 * Abstract class Animal focuses on the animal's common name, Latin name, and sound.
 * 
 * @author Joshua Zhou
 * @version November 9, 2018
 */
public abstract class Animal implements Comparable
{
    // instance variables - replace the example below with your own
    private String latinName;
    private String commonName;    
    /**
     * Creates an object in the Animal class.
     * 
     * @param   latin   the latin name
     * @param   common  the common name
     */
    public Animal(String latin, String common)
    {
        latinName=latin;
        commonName=common;
    }
    
    /**
     * Gets the Latin name of the animal.
     * 
     * @return  the Latin name of the animal
     */
    public String getLatinName()
    {
        return latinName;
    }
    
    /**
     * Gets the common name of the animal.
     * 
     * @return  the common name of the animal
     */
    public String getCommonName()
    {
        return commonName;
    }
    
    /**
     * Sets the latin name of the animal.
     * 
     * @param   latin   the latin name to be set
     */
    public void setLatinName(String latin)
    {
        latinName=latin;
    }
    
    /**
     * Sets the common name of the animal.
     * 
     * @param   common  the common name to be set
     */
    public void setCommonName(String common)
    {
        commonName=common;
    }
    
    /**
     * Gives the sound of the animal.
     * 
     * @return  the sound of the animal
     */
    public abstract String speak();
    
    /**
     * Compares the common name between the animal and obj.
     * 
     * @param   obj     the object to be compared
     * 
     * @return  0       if the common names are the same
     *          -1      if the common names are different
     *                  or if obj is not an Animal
     */
    @Override
    public int compareTo(Object obj)
    {
        if(obj instanceof Animal)
        {
            Animal ani=(Animal) obj;
            String name=this.getCommonName();
            String aniName=ani.getCommonName();
            if(name.equals(aniName))
            {
                return 0;
            }
        }
        return -1;
    }
}