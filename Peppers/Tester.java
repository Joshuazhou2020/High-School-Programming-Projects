import java.util.ArrayList;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    public final static void main(String[] args)
    {
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(6);
        list.add(1);
        list.add(8);
        
        int len=list.size();
        for(int i=0; i<len; i++)
        {
            list.add(i+1, new Integer(i));
            Object x=list.set(i, new Integer(i+2));
        }
        
        for(int i=0; i<list.size(); i++)
        {
            System.out.print(list.get(i)+"\t");
        }
    }
}
