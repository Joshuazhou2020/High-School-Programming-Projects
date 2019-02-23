public class Experiment extends Object implements Comparable
{
    private int x;
    public Experiment()
    {
        super();
        x=0;
    }
    
    public int getX()
    {
        return x;
    }
    
    public void setX(int y)
    {
        x=y;
    }
    
    @Override
    public String toString()
    {
        return "The value for x = " + getX();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Experiment)
        {
            Experiment xMan=(Experiment)obj;
            return xMan.getX() == this.getX();
        }
        return false;
    }
    
    @Override
    public int compareTo(Object obj)
    {
        if(obj instanceof Experiment)
        {
            Experiment xMan=(Experiment)obj;
            return this.getX()-xMan.getX();
        }
        return -556727964;
    }
}