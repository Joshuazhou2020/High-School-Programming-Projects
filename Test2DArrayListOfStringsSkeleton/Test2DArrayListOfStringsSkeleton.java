import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * Plays with 2-D ArrayList.
 * 
 * @author Susan King
 * @version November 18, 2016
 */
public class Test2DArrayListOfStringsSkeleton

{

    /**
     * Constructor for objects of class Test2D
     */
    public Test2DArrayListOfStringsSkeleton()
    {
        super();
    }

    
    /**
     * Create an ArrayList of ArrayList of Strings.
     * Add words to an ArrayList based upon the number of letters in each word.  For
     * example, if a word has three letters, add it to dict.get(3).
     * 
     * @param fileName  the name of the file
     * @throws IOException file is not found
     */
    public void readWordListInto2DArrayList(String fileName) throws IOException
    {
        List<List<String>> dictionary = new ArrayList<List<String>>();
        Scanner inFile = new Scanner(new File(fileName));
        while (inFile.hasNext())
        {
            String str = inFile.next().toLowerCase().trim();
            int length=str.length();
            dictionary.get(length).add(str);
        }
        inFile.close();
        printPortionOfArrayList(dictionary);
    }
    
    /**
     * Print out just a portion of the dictionary.
     * 
     * @param dictionary  a 2-D ArrayList of words
     */
    public void printPortionOfArrayList(List<List<String>> dictionary)
    {
        int len = 0;
        for (List<String> words:dictionary)
        {
            System.out.print("\n"+len + "\t" + words.size());
            for (int i = 0; i < 6 && i< words.size(); i++)
                System.out.print ("\t" + words.get(i));
            len++;
        }
        int wordCount = 0;
        // Calculate the word count
        System.out.println("\nTotal word count = " + wordCount);
    }
    /**
     * Test the methods.
     * 
     * @param  args  information from the command line
     * @throws IOException file is not found
     */
    public static void main(String[]args) throws IOException
    {
        Test2DArrayListOfStringsSkeleton tester = new Test2DArrayListOfStringsSkeleton();
        
        tester.readWordListInto2DArrayList("wordlist.txt");
        tester.readWordListInto2DArrayList("wordsEn.txt");
    }
}
