import java.io.*;
import java.util.*;

/**
 * Models hurricane information, works with Hurricane class
 * and the user to manipulate an array of hurricane data. 
 *
 * @author Susan King
 * @author Joshua Zhou
 * 
 * @version December 28, 2015
 * @version January 15, 2019
 */
public class HurricaneOrganizerArrayJoshua
{
    private Hurricane [] hurricanes;

    /**
     * Constructor for class HurricaneOrganizerArrayJoshua.
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     * 
     * @param   filename    the name of the file
     */
    public HurricaneOrganizerArrayJoshua(String filename)throws IOException
    {
        readFile(filename);   
    }

    /**
     * Returns the length of the file.
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     * 
     * @param   filename    the name of the file
     */
    private static int determineFileLength(String filename) throws IOException
    {
        Scanner inFile = new Scanner(new File(filename));
        int counter = 0;

        while(inFile.hasNextLine())
        {
            counter++;
            inFile.nextLine();
        }
        inFile.close();
        return counter;
    }

    /**
     * Reads the file.
     * 
     * @param   filename    the name of the file
     */
    public void readFile(String filename) throws IOException
    {
        hurricanes = new Hurricane [determineFileLength(filename)];
        int hurYear, hurPressure, hurSpeed;
        String hurName, hurMonth;
        Scanner inFile = new Scanner(new File(filename));

        for(int i = 0; i < hurricanes.length; i++)
        {
            hurYear = inFile.nextInt();
            hurMonth = inFile.next();
            hurPressure = inFile.nextInt();
            hurSpeed = inFile.nextInt();
            String tempName = inFile.nextLine();
            hurName = "";
            for(int k = 0; k < tempName.length(); k++)
            {
                char c = tempName.charAt(k);
                if(('a' <= c && c <= 'z') || ('A' <= c && c <='Z'))
                    hurName += c;
            }
            Hurricane h = new Hurricane(hurYear, hurMonth, hurPressure, hurSpeed, hurName);
            hurricanes [i] = h;
        }
        inFile.close();
    }

    /**
     * Finds the maximum wind speed of the hurricanes.
     * 
     * @return  the maximum wind speed
     */
    public int findMaxWindSpeed( )
    {
        int maxSpeed=Integer.MIN_VALUE;
        for(int i=0;i<hurricanes.length;i++)
        {
            maxSpeed=Math.max(maxSpeed,hurricanes[i].getSpeed());
        }
        return maxSpeed;
    }

    /**
     * Finds the maximum pressure of the hurricanes.
     * 
     * @return  the maximum pressure
     */
    public int findMaxPressure( )
    {
        int maxPressure=Integer.MIN_VALUE;
        for(int i=0;i<hurricanes.length;i++)
        {
            maxPressure=Math.max(maxPressure,hurricanes[i].getPressure());
        }
        return maxPressure;
    }

    /**
     * Finds the minimum wind speed of the hurricanes.
     * 
     * @return  the minimum wind speed
     */
    public int findMinWindSpeed( )
    {
        int minSpeed=Integer.MAX_VALUE;
        for(int i=0;i<hurricanes.length;i++)
        {
            minSpeed=Math.min(minSpeed,hurricanes[i].getSpeed());
        }
        return minSpeed;
    }

    /**
     * Finds the minimum pressure of the hurricanes.
     * 
     * @return  the minimum pressure
     */
    public int findMinPressure( )
    {
        int minPressure=Integer.MAX_VALUE;
        for(int i=0;i<hurricanes.length;i++)
        {
            minPressure=Math.min(minPressure,hurricanes[i].getPressure());
        }
        return minPressure;
    }

    /**
     * Calculates the average wind speed of the hurricanes.
     * 
     * @return  the average wind speed
     */
    public double calculateAverageWindSpeed( )
    {
        double speedSum=0;
        for(int i=0;i<hurricanes.length;i++)
        {
            speedSum+=hurricanes[i].getSpeed();
        }
        return speedSum/hurricanes.length;
    }

    /**
     * Calculates the average pressure of the hurricanes.
     * 
     * @return  the average pressure
     */
    public double calculateAveragePressure( )
    {
        double pressureSum=0;
        for(int i=0;i<hurricanes.length;i++)
        {
            pressureSum+=hurricanes[i].getPressure();
        }
        return pressureSum/hurricanes.length;
    }

    /**
     * Calculates the average category of the hurricanes.
     * 
     * @return  the average category
     */
    public double calculateAverageCategory( )
    {
        double categorySum=0;
        for(int i=0;i<hurricanes.length;i++)
        {
            categorySum+=hurricanes[i].getCategory();
        }
        return categorySum/hurricanes.length;
    }

    /**
     * Sorts ascending based upon the hurricanes' years,
     * The algorithm is selection sort.
     */
    public void sortYears()
    {
        for(int outer=0;outer<hurricanes.length;outer++)
        {
            int mindex=outer;
            for(int inner=outer;inner<hurricanes.length;inner++)
            {
                if(hurricanes[inner].compareYearTo(hurricanes[mindex])<0)
                {
                    mindex=inner;
                }
            }
            Hurricane temp=hurricanes[mindex];
            hurricanes[mindex]=hurricanes[outer];
            hurricanes[outer]=temp;
        }
    }

    /**
     * Lexicographically sorts hurricanes based on the hurricanes' name, 
     * using insertion sort.
     */
    public void sortNames()
    {
        // write this code
        for(int outer=1;outer<hurricanes.length;outer++)
        {
            int maxdex=outer-1;
            Hurricane temp=hurricanes[outer];
            while(maxdex>=0&&hurricanes[maxdex].compareNameTo(temp)>0)
            {
                hurricanes[maxdex+1]=hurricanes[maxdex];
                maxdex--;
            }
            hurricanes[maxdex+1]=temp;
        }
    }

    /**
     * Sorts descending based upon the hurricanes' categories,
     * using selection sort.
     */
    public void sortCategories()
    {
        for(int outer=0;outer<hurricanes.length;outer++)
        {
            int maxdex=outer;
            for(int inner=outer;inner<hurricanes.length;inner++)
            {
                if(hurricanes[inner].compareCategoryTo(hurricanes[maxdex])>0)
                {
                    maxdex=inner;
                }
            }
            Hurricane temp=hurricanes[maxdex];
            hurricanes[maxdex]=hurricanes[outer];
            hurricanes[outer]=temp;
        }
    }  

    /**
     * Sorts descending based upon pressures using a non-recursive merge sort.
     */
    public void sortPressures()
    {
        // write this code
        int len=hurricanes.length;
        int mid=len/2;
        Hurricane[] merged=new Hurricane[len];
        sortPressuresHelper(0,mid);
        sortPressuresHelper(mid,len);
        int findex=0;
        int sindex=mid;
        for(int index=0;index<len;index++)
        {
            if(findex>=mid)
            {
                merged[index]=hurricanes[sindex];
                sindex++;
            }
            else if(sindex>=len)
            {
                merged[index]=hurricanes[findex];
                findex++;
            }
            else if(hurricanes[findex].comparePressureTo(hurricanes[sindex])>=0)
            {
                merged[index]=hurricanes[findex];
                findex++;
            }
            else
            {
                merged[index]=hurricanes[sindex];
                sindex++;
            }
        }
        hurricanes=merged;
    }
    
    /**
     * Sorts descending a portion of array based upon pressure, 
     * using selection sort.
     * 
     * @param   start   the first index to start the sort
     * @param   end     one past the last index to sort; hence, end position
     *                  is excluded in the sort
     */
    private void sortPressuresHelper (int start, int end)
    {
        // write this code
        for(int outer=start;outer<end;outer++)
        {
            int maxdex=outer;
            for(int inner=outer;inner<end;inner++)
            {
                if(hurricanes[inner].comparePressureTo(hurricanes[maxdex])>0)
                {
                    maxdex=inner;
                }
            }
            Hurricane temp=hurricanes[maxdex];
            hurricanes[maxdex]=hurricanes[outer];
            hurricanes[outer]=temp;
        }
    }

    /**
     * Sorts ascending based upon wind speeds using a recursive merge sort. 
     * 
     * @param   low     the lower index
     * @param   high    the upper index
     */
    public void sortWindSpeeds(int low, int high)
    {
        if(low==high)
        {
            return;
        }
        int mid=(low+high)/2;
        sortWindSpeeds(low,mid);
        sortWindSpeeds(mid+1,high);
        mergeWindSpeedsSortHelper(low,mid+1,high);
    }

    /**
     * Merges two consecutive parts of an array, using wind speed as a criteria
     * and a temporary array.  The merge results in an ascending sort between
     * the two given indices.
     * 
     * @precondition the two parts are sorted ascending based upon wind speed
     * 
     * @param low   the starting index of one part of the array.
     *              This index is included in the first half.
     * @param mid   the starting index of the second part of the array.
     *              This index is included in the second half.
     * @param high  the ending index of the second part of the array.  
     *              This index is included in the merge.
     */
    private void mergeWindSpeedsSortHelper(int low, int mid, int high)
    {
        // write this code
        Hurricane[] merged=new Hurricane[high-low+1];
        int findex=low;
        int sindex=mid;
        for(int index=0;index<merged.length;index++)
        {
            if(findex>=mid)
            {
                merged[index]=hurricanes[sindex];
                sindex++;
            }
            else if(sindex>high)
            {
                merged[index]=hurricanes[findex];
                findex++;
            }
            else if(hurricanes[findex].compareSpeedTo(hurricanes[sindex])<0)
            {
                merged[index]=hurricanes[findex];
                findex++;
            }
            else
            {
                merged[index]=hurricanes[sindex];
                sindex++;
            }
        }
        for(int index=0;index<merged.length;index++)
        {
            hurricanes[low+index]=merged[index];
        }
    }

    /**
     * Sequential search for all the hurricanes in a given year.
     * 
     * @param   year    the year to be used in the search
     * @return  an array of objects in Hurricane that occured in
     *          the parameter year
     */
    public Hurricane [] searchYear(int year)
    {
        int counter = 0;
        //Find []h length
        // write this code
        for(int index=0;index<hurricanes.length;index++)
        {
            if(hurricanes[index].getYear()==year)
            {
                counter++;
            }
        }

        Hurricane[] h = new Hurricane[counter];
        int count=0;
        // write the code
        for(int index=0;index<hurricanes.length;index++)
        {
            if(hurricanes[index].getYear()==year)
            {
                h[count]=hurricanes[index];
                count++;
            }
        }
        return h;
    }     

    /**
     * Binary search for a hurricane name.
     * 
     * @param  name   hurricane name being search
     * @return a Hurricane array of all objects in hurricanes with specified name. 
     *         Returns null if there are no matches
     */
    public Hurricane[ ] searchHurricaneName(String name)
    {
        sortNames();
        return searchHurricaneNameHelper(name, 0, hurricanes.length - 1);
    }

    /**
     * Recursive binary search for a hurricane name.  This is the helper
     * for searchHurricaneName.
     * 
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name  hurricane name to search for
     * @param   low   the smallest index that needs to be checked
     * @param   high  the highest index that needs to be checked
     * @return  a Hurricane array of all Hurricane objects with a specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] searchHurricaneNameHelper(String name, int low , int high)
    {
        // Test for the base case when a match is not found
        //return null;

        // Test for match

        
        
        // Determine if the potential match is in the 
        // "first half" of the considered items in the array

        
        
        // The potential match must be in the
        // "second half" of the considered items in the array

        //base
        if(low>high)
        {
            return null;
        }
        int mid=(low+high)/2;
        int compare=hurricanes[mid].getName().compareTo(name);
        if(compare==0)
        {
            return retrieveMatchedNames(name,mid);
        }
        if(compare>0)
        {
            return searchHurricaneNameHelper(name,low,mid-1);
        }
        return searchHurricaneNameHelper(name,mid+1,high);
    }

    /**
     * Supports Binary Search method to get the full range of matches.
     * 
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name hurricane name being search for
     * @param   index  the index where a match was found
     * @return  a Hurricane array with objects from hurricanes with specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] retrieveMatchedNames (String name, int index)
    {
        // Find the start where the matches start:

        
        // Find the end of the matches:

        
        // Copy the objects whose names match:

        //return null;  // correct this line
        int findex=index-1;
        int lindex=index+1;
        while(findex>=0&&hurricanes[findex].getName().compareTo(name)==0)
        {
            findex--;
        }
        findex++;
        while(lindex<hurricanes.length&&hurricanes[lindex].getName().compareTo(name)==0)
        {
            lindex++;
        }
        lindex--;
        Hurricane[] matches=new Hurricane[lindex-findex+1];
        for(int i=0;i<matches.length;i++)
        {
            matches[i]=hurricanes[findex+i];
        }
        return matches;
    }

    /**
     * Comment this method even though you did not write it.
     */
    public void printHeader()
    {
        System.out.println("\n\n");
        System.out.printf("%-4s %-5s %-15s %-5s %-5s %-5s \n", 
            "Year", "Mon.", "Name", "Cat.", "Knots", "Pressure");
    }

    /**
     * Comment this method even though you did not write it.
     */
    public void printHurricanes()
    {
        printHurricanes(hurricanes);
    }

    /**
     * Add comments here even though you did not write the method.
     * 
     * @param   hurs    the Hurricane array to be printed
     */
    public void printHurricanes(Hurricane [] hurs)
    {
        if(hurs==null||hurs.length == 0)
        {
            System.out.println("\nVoid of hurricane data.");
            return;
        }
        printHeader();
        for(Hurricane h: hurs)
        {
            System.out.println(h);
        }
    }

    /**
     * Add comments here even though you did not write the method.
     */
    public void printMenu()
    {
        System.out.println("\n\nEnter option: ");
        System.out.println("\t 1 - Print all hurricane data \n" +
            "\t 2 - Print maximum and minimum data \n" +
            "\t 3 - Print averages \n" +
            "\t 4 - Sort hurricanes by year \n" +
            "\t 5 - Sort hurricanes by name \n" +
            "\t 6 - Sort hurricanes by category, descending \n" +
            "\t 7 - Sort hurricanes by pressure, descending \n" +
            "\t 8 - Sort hurricanes by speed \n" + 
            "\t 9 - Search for hurricanes for a given year \n" +
            "\t10 - Search for a given hurricane by name \n" +
            "\t11 - Quit \n");
    }

    /**
     * Add comments here even though you did not write the method.
     */
    public void printMaxAndMin( )
    {
        System.out.println("Maximum wind speed is " + 
            findMaxWindSpeed( ) +
            " knots and minimum wind speed is " + 
            findMinWindSpeed( ) + " knots.");
        System.out.println("Maximum pressure is " + 
            findMaxPressure( ) +
            " and minimum pressure is " + 
            findMinPressure( ) + ".");
    }

    /**
     * Add comments here even though you did not write the method.
     */
    public void printAverages( )
    {
        System.out.printf("Average wind speed is %5.2f knots. \n" , 
            calculateAverageWindSpeed( ));
        System.out.printf("Average pressure is %5.2f. \n" , 
            calculateAveragePressure( ));
        System.out.printf("Average category is %5.2f. \n" , 
            calculateAverageCategory( ));
    }

    /**
     * Add comments here even though you did not write the method.
     * 
     * @return  true    if the user is done; otherwise,
     *                  false
     */
    public boolean interactWithUser( )
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        printMenu();
        int choice = in.nextInt();
        // clear the input buffer
        in.nextLine();

        if(choice == 1)
        {
            printHurricanes( ); 
        }
        else if (choice == 2)
        {
            printMaxAndMin( );
        }
        else if (choice == 3)
        {
            printAverages( );
        }
        else if(choice == 4)
        {
            sortYears();
            printHurricanes( );
        }
        else if(choice == 5)
        {
            sortNames();
            printHurricanes( );
        }
        else if(choice == 6)
        {
            sortCategories();
            printHurricanes( );
        }
        else if(choice == 7)
        {
            sortPressures();
            printHurricanes( );
        }
        else if(choice == 8)
        {
            sortWindSpeeds(0, hurricanes.length - 1);
            printHurricanes( );
        }
        else if(choice == 9)
        {
            System.out.print("\n\tWhich year do you want to search for?\n\t");
            int year = in.nextInt();
            printHurricanes(searchYear(year));
        }
        else if(choice == 10)
        {
            System.out.print("\n\tWhich name do you want to search for?\n\t");
            String name = in.next();
            printHurricanes(searchHurricaneName(name));
        }
        else if (choice == 11)
        {
            done = true;
        }  
        return done;
    }

    /**
     * Comment the method even though you did not write it.
     * 
     * @param args  user's information from the command line
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     */
    public static void main (String [] args) throws IOException
    {
        HurricaneOrganizerArrayJoshua cane = new HurricaneOrganizerArrayJoshua("hurricanedata.txt");
        boolean areWeDoneYet = false;
        while ( ! areWeDoneYet)
        {
            areWeDoneYet = cane.interactWithUser( );    
        }
    }
}
