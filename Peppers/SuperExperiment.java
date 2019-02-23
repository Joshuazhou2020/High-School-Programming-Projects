public class SuperExperiment extends Experiment
{
    private double z;
    private static final double EPSILON=0.05;
    public SuperExperiment()
    {
        super();
        z=43.28;
    }
    public double getZ()
    {
        return z;
    }
    public void setZ(int zzTop)
    {
        z=zzTop;
    }
    @Override
    public String toString()
    {
        return "I am the best of the best. " + super.toString() + "z = " + getZ();
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof SuperExperiment)
        {
            SuperExperiment superman=(SuperExperiment)obj;
            double diffZ=this.getZ() - superman.getZ();
            return super.equals(superman) && Math.abs(diffZ)<EPSILON;
        }
        return false;
    }
    @Override
    public int compareTo(Object obj)
    {
        if(obj instanceof SuperExperiment)
        {
            SuperExperiment superman=(SuperExperiment)obj;
            if(this.equals(superman))
                return 0;
            int diffX=super.compareTo(superman);
            if(diffX!=0)
                return diffX;
            double diffZ=this.getZ()-superman.getZ();
            if(diffZ>0)
                return 1;
            return -1;
        }
        throw new IllegalArgumentException("Needs a SuperExperiment object.");
        //return 358789;
    }
}