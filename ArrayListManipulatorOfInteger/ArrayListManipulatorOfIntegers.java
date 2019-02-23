import java.util.Scanner;
import java.util.ArrayList;

/**
 * Cover the basics of ArrayList from the first day lecture.
 * 
 * @author      Susan King 
 * @author      Joshua Zhou
 * @version     November 22, 2017
 * 
 * Students:  Look for three dots.  You write the necessary code there.
 */
public class ArrayListManipulatorOfIntegers
{
    /**
     * Constructs objects of class ArrayListManipulatorOfIntegers.
     */
    // ... write the default constructor that has no code
    public ArrayListManipulatorOfIntegers()
    {
        super();
    }

    /**
     * Generates random numbers between -500 and 500.
     * The number of random numbers is itself a random number
     * between 0 and 20.
     * 
     * @return an ArrayList of random numbers
     */
    public ArrayList<Integer> generateRandomData( )
    {
        ArrayList <Integer> data = new ArrayList <Integer>( );
        int len = (int)(Math.random( ) * 21);  // random number of numbers
        //  ... fill up the ArrayList with numbers between -500 and 500
        for(int i=0; i<len; i++)
        {
            int rand=(int)(Math.random()*(-1000)+500.5);
            data.add(rand);
        }
        return data;
    }

    /**
     * Generates a predictable sequence of numbers with many
     * identical values to test the two methods that "remove neighboring 
     * duplicates".
     * 
     * @return an ArrayList of selected numbers
     */
    public ArrayList<Integer> generateFixedData( )
    {
        ArrayList <Integer> data = new ArrayList <Integer>( );
        data.add(7);
        data.add(10);
        data.add(10);
        data.add(15);
        data.add(15);
        data.add(15);
        data.add(50);
        data.add(50);
        data.add(50);
        data.add(50);
        data.add(50);
        data.add(7);
        return data;
    }
    
    /**
     * Generates an empty ArrayList.
     * 
     * @return an empty ArrayList
     */
    public ArrayList<Integer> generateEmptyArrayList( )
    {
        ArrayList<Integer> list=new ArrayList<Integer>();
        return list;  // ... change 
    }
    
    /**
     * Outputs an ArrayList of Integers.
     * 
     * @param  numbers   an ArrayList of Integers
     */
    public void printData(ArrayList<Integer> numbers)
    { 
        if (numbers.size()==0) // ... change to test if ArrayList is empty
        {
            System.out.println("ArrayList is empty.");
            return;
        }
        
        // output the elements in the array
        for (int i=0 ; i<numbers.size(); i++) // ... finish the for statement
        {
            System.out.println("numbers\' " + i + " element = " + numbers.get(i));
        }
    }

    /**
     * Generates a summation of all the Integers in an ArrayList.
     * 
     * @param  nums   an ArrayList of Integers
     * @return sum of all numbers in an ArrayList
     */    
    public long sumOfData(ArrayList<Integer> nums)
    {
        long sum = 0; // ... correct this statement
        // ... sum the elements in ArrayList nums
        for(int i=0; i<nums.size(); i++)
        {
            sum+=nums.get(i);
        }
        return sum;
    }

    /**
     * Generates a product of all the Integers in an ArrayList.
     * 
     * @param  numbs   an ArrayList of Integers
     * @return product of all numbers in an ArrayList. If the
     *         ArrayList is empty, return 0
     */       
    public long productOfData(ArrayList<Integer> numbs)
    {
        if(numbs.size()==0)
        {
            return 0;
        }
        long product = 1; // ... correct this statement
        // ... generate the product of the elements in ArrayList numbs
        for(int i=0; i<numbs.size(); i++)
        {
            product*=numbs.get(i);
        }
        return product;
    }   

    /**
     * Finds the maximum Integer in an ArrayList. If the ArrayList is
     * empty, the smallest integer value is returned.
     * 
     * @param  values   an ArrayList of Integers
     * @return maximum numbers in an ArrayList
     */     
    public int getMaxOfData(ArrayList<Integer> values)
    {
        int max = Integer.MIN_VALUE; // ... correct this statement
        for(int i=0; i<values.size(); i++)
        {
            max=Math.max(max,values.get(i));
        }
        return max;
    }   

    /**
     * Finds the minimum Integer in an ArrayList. If the ArrayList is
     * empty, the largest integer value is returned.
     * 
     * @param  vals   an ArrayList of Integers
     * @return minimum numbers in an ArrayList
     */       
    public int getMinOfData(ArrayList<Integer> vals)
    {
        int min = Integer.MAX_VALUE; // ... correct this statement
        // ... find the minimum elements in ArrayList vals
        for(int i=0; i<vals.size(); i++)
        {
            min=Math.min(min,vals.get(i));
        }
        return min;
    } 

    /**
     * Turns all even Integer values in an ArrayList to the value of 6.
     * 
     * @param  numSeries   ArrayList of Integers
     */     
    public void replaceEvenWith6(ArrayList<Integer> numSeries)
    {
        for(int i=0; i<numSeries.size(); i++)
        {
            if(numSeries.get(i)%2==0)
            {
                numSeries.set(i,6);
            }
        }
    }

    /**
     * Turns all Integer values to their absolute values in an ArrayList.
     * 
     * @param  seriesOfNums   an ArrayList of Integers
     */      
    public void setAbsolute(ArrayList<Integer> seriesOfNums)
    {
        for(int i=0; i<seriesOfNums.size(); i++)
        {
            int abs=Math.abs(seriesOfNums.get(i));
            seriesOfNums.set(i,abs);
        }
    }

    /**
     * Removes all odd Integer values from an ArrayList.
     * 
     * @param  seriesOfNumbers   an ArrayList of Integers
     */   
    public void removeOdds(ArrayList<Integer> seriesOfNumbers)
    {
        // ... write the code to match the description of the method.
        // HINT:  go through the ArrayList from the last index to
        // zero.  This avoids skipping over entries.
        for(int i=seriesOfNumbers.size()-1; i>=0; i--)
        {
            if(seriesOfNumbers.get(i)%2==1)
            {
                seriesOfNumbers.remove(i);
            }
        }
    }

    /**
     * Removes all but one duplicate, contiguous Integer values from 
     * an ArrayList.  If the same value is repeated in three contiguous
     * positions, only one of the values remains.  Likewise, if the
     * same value is repeated in "n" contigous positions, only
     * one of the values remains.
     * 
     * @param  quantities   an ArrayList of Integers
     * @postcondition   If "n" identical neighboring values in the  
     *                  ArrayList, "n-1" of them are removed
     */     
    public void removeAllButOneNeighboringDuplicates(ArrayList<Integer> quantities)
    {
        // ... write the code to match the description of the method.
        for(int i=0; i<quantities.size()-1; i++)
        {
            if(quantities.get(i)==quantities.get(i+1))
            {
                quantities.remove(i+1);
                i--;
            }
        }
    }

    /**
     * Duplicates all Integer values that are a multiple of three
     * in an ArrayList.  If the multiple of three is at "n"
     * position, that value is now at both position "n"
     * and "n+1".
     * 
     * @param  quans   an ArrayList of Integers
     * @postcondition   Duplicates all Integer values that are a 
     *                  multiple of 3 in an ArrayList
     */         
    public void doubleUp(ArrayList<Integer> quans)
    {
        // ... finish the code to match the description of the method.
        // ... This can be tricky.
        for(int i=0; i<quans.size(); i++)
        {
            if(quans.get(i)%3==0)
            {
                int num=quans.get(i);
                quans.add(i,num);
                i++;
            }
        }
    }

    /**
     * Removes all of continguous Integer values that are
     * from an ArrayList.  If removing of values creates
     * continguous identical values, they are to be
     * removed.
     * 
     * @param  collectionOfNumbers   an ArrayList of Integers
     * @postcondition   All of neighboring Integer values that
     *                  are the same are removed from the 
     *                  ArrayList
     */   
    public void removeAllNeighboringDuplicates(ArrayList<Integer> 
                                               collectionOfNumbers)
    {
        // ... finish the code to match the description of the method.
        // ... This can be tricky.
        int index=collectionOfNumbers.size()-1;
        while(index>0)
        {
            if(collectionOfNumbers.get(index).equals(collectionOfNumbers.get(index-1)))
            {
                int store=collectionOfNumbers.remove(index);
                index--;
                while(index>=0&&
                      collectionOfNumbers.get(index)==store)
                {
                    collectionOfNumbers.remove(index);
                    index--;
                }
                index=Math.min(index+1,collectionOfNumbers.size()-1);
            }
            else
                index--;
        }
    }

    /**
     * Prints the menu for the user to read.
     */
    public void printMenu( )
    {
        System.out.println("Enter option: ");
        System.out.println(
            " 1 - generate new random data in an ArrayList \n" +
            " 2 - print ArrayList \n" +
            " 3 - print sum \n" +
            " 4 - print product \n" +
            " 5 - print max and min \n" +
            " 6 - replace even numbers with 6 \n" +
            " 7 - make all numbers absolute \n" +
            " 8 - remove all odd numbers \n" +
            " 9 - double up \n" +
            "10 - remove all but one neighboring duplicates \n" +
            "11 - remove all neighboring duplicates \n" +
            "12 - generate predicatable data in an ArrayList \n" +
            "13 - generate an empty ArrayList \n" +
            "14 - quit");
    }

    /**
     * Allows the user to select what action he or she wishes to 
     * make.  The desired action is then executed.
     */
    public void interactWithUser( )
    {
        Scanner in = new Scanner(System.in);
        ArrayList <Integer> testData = generateRandomData( );
        int choice = 0;
        printData(testData);
        while (choice != 14)
        {
            printMenu();
            choice = in.nextInt();
            // clear the input buffer
            in.nextLine();

            if(choice == 1)
            {
                testData = generateRandomData( ); 
            }
            else if (choice == 2)
            {
                printData( testData );
            }
            else if (choice == 3)
            {
                System.out.println( "Sum = " + sumOfData(testData) );
            }
            else if (choice == 4)
            {
                System.out.println( "Product = " + productOfData(testData) );        
            }
            else if (choice == 5)
            {       
                System.out.println( "Max = " + getMaxOfData(testData) );     
                System.out.println( "Min = " + getMinOfData(testData) );
            }
            else if (choice == 6)
            {
                replaceEvenWith6(testData);
            }
            else if (choice == 7)
            {
                setAbsolute(testData);
            }  
            else if (choice == 8)
            {
                removeOdds(testData);
            }
            else if (choice == 9)
            {
                doubleUp(testData);
            }  
            else if (choice == 10)
            {
                removeAllButOneNeighboringDuplicates(testData);
            }  
            else if (choice == 11)
            {
                removeAllNeighboringDuplicates(testData);
            }  
            else if (choice == 12)
            {
                testData = generateFixedData();
            } 
            else if (choice == 13)
            {
                testData = generateEmptyArrayList();
            } 
            else if (choice == 14)
            {
                System.out.println("Goodbye");
            }
        }
    }

    /**
     * Tests the code for ManipulatorOfIntegerArrayList.  The code is designed
     * to build skills with ArrayLists.
     * 
     * @param args   information passed from the user via the command line
     */
    public static void main(String[]args)
    {
        ArrayListManipulatorOfIntegers learner = new ArrayListManipulatorOfIntegers( );
        learner.interactWithUser( );
    }

}
