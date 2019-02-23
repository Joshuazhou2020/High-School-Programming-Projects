public class ExperimentRunner
{
    public static void main (String [] args)
    {
        Experiment scientist = new Experiment();
        System.out.println(scientist);
        ((Experiment)scientist).setX(142);

        System.out.println(scientist.toString());

        Experiment beaker = new SuperExperiment();
        beaker.setX(Integer.MAX_VALUE);
        System.out.println(beaker);

        System.out.println("scientist equals scientist = " + scientist.equals(scientist));
        System.out.println("scientist equals beaker = " + scientist.equals(beaker));
        System.out.println("beaker equals scientist = " + beaker.equals(scientist));

        System.out.println("scientist compareTo scientist = " + scientist.compareTo(scientist));
        System.out.println("scientist compareTo beaker = " + scientist.compareTo(beaker));
        System.out.println("beaker compareTo scientist = " + beaker.compareTo(scientist));
    }
}