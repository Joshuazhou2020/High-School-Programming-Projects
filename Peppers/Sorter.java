
/**
 * Write a description of class SearchSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sorter
{
    // instance variables - replace the example below with your own
    private int[] nums;
    private int len;
    /**
     * Constructor for objects of class SearchSort
     */
    public Sorter(int length)
    {
        len=length;
        nums=new int[len];
        for(int i=0;i<len;i++)
        {
            int fill=(int)(Math.random()*50);
            nums[i]=fill;
        }
    }

    public void recursiveMergeSort(int low,int high)
    {
        if(low==high)
        {
            return;
        }
        int mid=(low+high)/2;
        recursiveMergeSort(low,mid);
        recursiveMergeSort(mid,high);
        mergeSortHelper(low,mid+1,high);
    }

    public final static void main(String[] args)
    {
        Sorter susan=new Sorter(10);
        for(int i=0;i<susan.len;i++)
        {
            System.out.print(susan.nums[i]+"\t");
        }
        System.out.println();
        susan.sort();
        for(int i=0;i<susan.len;i++)
        {
            System.out.print(susan.nums[i]+"\t");
        }
    }
}
