import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;


/**
 * Reads in a text file and analyzes the frequency of the
 * words.
 * 
 * Note to students:  you need to add code and methods to the class to
 *                    complete the project.  Consult the rubric to see
 *                    what needs to be added.
 * 
 * @author Susan King 
 * @author Joshua Zhou
 * @version February 6, 2012
 * @version March 16, 2016     clarified documentation
 * 
 */
public class WordAnalysis
{
    // instance variables 
    private ArrayList <Word> words;

    /**
     * Creates a list of words from a file and frequency of use
     * 
     * @param  fileName    the name of the text of the book
     * @throws IOException file is not found
     */
    public WordAnalysis(String fileName) throws IOException
    {
        words = new ArrayList<Word>( );
        readFile(fileName);
    }

    /**
     * Reads the file, storing words in an ArrayList.  Words not seen before 
     * are added to the ArrayList.  Words seen before have their frequency
     * increased by one.
     * 
     * @param fileName   the pathname of the file
     * @throws IOException file is not found
     */
    private void readFile(String fileName) throws IOException
    {
        Scanner inFile = new Scanner(new File(fileName));

        while (inFile.hasNext())
        {
            String str = inFile.next().toLowerCase( ).trim();
            String newWord = cleanUp(str);
            if (newWord != null && 0 < newWord.length())
            {
                findOrInsertWord(newWord);
            }
        }
        inFile.close();
    }

    /**
     * Cleans up a string of characters so it has only apostrophes,
     * hypens, or letters a through z.
     * 
     * @param s  the original input string
     * 
     * @return a string object with only letters.  If an apostrophe
     *         or a dash has a letter before and after it, that
     *         character is also included.
     */
    private String cleanUp(String s)
    {
        String letters = "";
        for (int i = 0 ; i < s.length() ; i++)
        {
            String letter = s.substring(i,i+1);
            if (isLetter(letter))
            {
                letters += letter;
            }
            else if (letter.equals("\'") || letter.equals("-"))
            {
                if (isLetter(s,i-1) && isLetter(s,i+1))
                    letters += letter;
            }
        }
        return letters;
    }

    /**
     * Returns whether the character at a particular index in the
     * String x is a letter (between 'a' and 'z', or 'A' and 'Z, 
     * inclusive) or not.
     * 
     * @param  x     string of characters whose index is being tested
     * @param  index the position in the String x that is being tested (for being a letter)
     * 
     * @return true  if the character at position index is a letter; otherwise,
     *         false
     */
    private boolean isLetter(String x , int index)
    {
        if (0 <= index  && index < x.length())
        {
            String c = x.substring(index,index+1);
            if  (c.compareTo("a") >= 0 && c.compareTo("z") <= 0 ||
                 c.compareTo("A") >= 0 && c.compareTo("Z") <= 0)
                return true;
        }
        return false;  
    }

    /**
     * Returns whether the character in the parameter str is a letter 
     * (between 'a' and 'z', or 'A' and 'Z, inclusive) or not.
     * 
     * @param str     String of one character
     *
     * @return true if the str has one character and that character is a letter; otherwise,
     *         false
     */
    private boolean isLetter(String str)
    {
        if (str.length()  == 1)
        {
            String c = str.substring(0,1);
            if  (c.compareTo("a") >= 0 && c.compareTo("z") <= 0 ||
                 c.compareTo("A") >= 0 && c.compareTo("Z") <= 0)
                return true;
        }
        return false;  
    }

    /**
     * Finds the txt in the words list.  Once found, it adds one
     * to the frequency.  If txt is not in the words list, txt is
     * added to the words list.  This method uses a modified binary 
     * search to do this algorithm.
     * 
     * @precondition  words list is in lexicographic order
     * @postcondition words list is in lexicographic order
     * 
     * @param txt  the word to be found in words list or added to words
     * @return     the position txt occupies in words list
     */
    private int findOrInsertWord(String txt)
    {
        int high = words.size( ) - 1;
        int low = 0;
        int mid = 0;
        while (high >= low)
        {
            mid = (high + low) / 2;
            int c = words.get(mid).getWord().compareTo(txt);
            if (c == 0)
            {
                // match has been found so
                // add one to the word's frequency:
                words.get(mid).addOne();
                return mid;
            }
            else if (c < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        // no match was found so txt is added to words list
        return addWord(txt, high);
    }

    /**
     * Inserts the word alphabetically into list words, starting
     * at the specified index.   
     * 
     * @preconditon   words list is in lexicographic order
     * @postcondition words list is in lexicographic order
     * 
     * @param text  the word to be added
     * @param index the approximate location where the new word
     *              is to be inserted
     * @return      the position text occupies in words list             
     */
    private int addWord(String text, int index)
    {
        // make sure that index is the correct position to insert the new
        // word in the words list
        while (index >= 0 && index < words.size() && 
               words.get(index).getWord().compareTo(text) < 0)
        {
            index++;
        }

        Word w = new Word(text);
        // determine if insertion is a normal or special case
        if (0 < index && index < words.size())
        {
            // place w at the appropriate place in words list
            words.add(index,w);
            return index;  
        }
        else if (index < 0 && words.size() == 0)
        {
            // first word to be added to the ArrayList words list
            words.add(w);
            return 0;
        }
        else if (index < 0)
        {
            // place w at the start of the ArrayList words list
            words.add(0, w);
            return 0;
        }
        // place w at the end of the ArrayList
        words.add(w);
        return words.size() - 1;
    }

    /**
     * Prints out all the words in the words list. 
     * Note: the organization of the list (ordered alphabetically or 
     *       by frequency) affects what is printed.
     */
    public void print()
    {
        for(int i=0;i<words.size();i++)
        {
            System.out.println(words.get(i));
        }
    }

    /**
     * Prints out the first "x" number of words in the words list. 
     * 
     * Note: the organization of the list (ordered lexicographically or 
     *       by frequency) affects what is printed.
     * 
     * @param x  the number of words to be printed from words list
     */
    public void printTopWords(int x)
    {
        for(int i=0;i<x;i++)
        {
            System.out.println(words.get(i));
        }
    }

    /**
     * Prints the word at a particular position in the words list.
     * 
     * @param index the position of interest in the words list
     */
    public void printWord(int index)
    {
        if (0 <= index && index < words.size())
            System.out.println(words.get(index));
        else
            System.out.println("No data at index " + index);
    }

    /**
     * Determines how many words, in total, are in the original file that was read in.
     * 
     * @return the total number of words that are in the original document;
     *         in other words, the total frequency of the words in "words"
     *         list
     */
    public long sumWords()
    {
        long total=0;
        for(int i=0;i<words.size();i++)
        {
            total=total+words.get(i).getFrequency();
        }
        return total;
    }

    /**
     * Determines how many times the top number of words in "words" list
     * have appeared in the original document.  
     * Note: the organization of the list (ordered alphabetically or 
     *       by frequency) affects this outcome.
     * 
     * @param number the number of words which are to be used to
     *               generate the sum.  The "number" indicates the 
     *               first "number" positions in the words list.
     *               
     * @return how many times the top "number" words occurs
     */
    public long sumTopWords( int number )
    {
        long total=0;
        for(int i=0;i<number;i++)
        {
            total=total+words.get(i).getFrequency();
        }
        return total;
    }

    /**
     * Determines the proportion of the specified top number
     * of words in the "words" list divided by the total number of
     * words in the text.
     * 
     * Here are two examples using the book "The Tale of Peter Rabbit,"
     * which has 959 total words:
     * 
     *      If the two most frequent words are  
     *          "the", which appears 47 times, and  
     *          "and", which appears 44 times.
     *      In this case, getWordQuotient(2) returns 0.094890...
     *      
     *      Alphabetically, the first two words in words are:
     *          "a", which appears 28 times, and
     *          "about", which appears 2 times.
     *      In this case, getWordQuotient(2) returns 0.031282...
     * 
     * Hence the organization of the list (whether ordered 
     * lexicographically or by frequency) affects this outcome.
     * 
     * @param num    the number of words which are to be used to create
     *               the ratio.  The number indicates the first "num"
     *               positions in the words list.
     * @return the quotient as described in the summary
     */
    public double getWordQuotient(int num)
    {
        long total=sumTopWords(num);
        return (double)(total/sumWords());
    }

    
    
    /**
     * Calculates a rounded percentage form of the result
     * of getWordQuotient.
     * 
     * @param  num   the number of words being considered
     * @return the rounded percentage
     */
    private int calculatePercentage(int num)
    {
        return (int)(getWordQuotient(num)*100);
    }
    
    /**
     * Returns how many different words are in the original file 
     * that was read in.  I.e., the number of words in the original
     * file, excluding repetitions.  To state it another way, each
     * word in the list counts exactly once, regardless of its frequency.
     * 
     * @return the total number of different words that are in the document.
     */
    public int getNumberOfUniqueWords()
    {
        return words.size();
    }

    /**
     * Sorts the words alphabetically.
     */
    public void sortWords( )
    {
        sortWordsHelper(0,words.size()-1);
    }

    /**
     * Sort "words" list lexicographically using a recursive merge sort.
     * This is a helper method for sortWords.
     *       
     * @param low    the smallest index to be used in this portion of the sort
     * @param high   the last index to be used (inclusive) in this portion of 
     *               the sort
     */
    private void sortWordsHelper(int low , int high)
    {
        //base case
        if(low==high)
        {
            return;
        }
        //reductive case
        int mid=(low+high)/2;
        sortWordsHelper(low,mid);
        sortWordsHelper(mid+1,high);
        mergeWords(low,mid+1,high);
    }

    /**
     * Merge portions of the "words" list lexicographically by the text 
     * in the Word objects.  This is a helper method for sortWordsHelper.
     *       
     * @param low    the smallest index to be used in this portion of the merge
     * @param mid    the start of the second half of the array to be considered
     * @param high   the last index to be used (inclusive) in this portion of 
     *               the merge
     */
    private void mergeWords(int low , int mid, int high)
    {
        ArrayList<Word> merged=new ArrayList<Word>();
        int findex=low;
        int sindex=mid;
        for(int index=0;index<high-low+1;index++)
        {
            if(findex>=mid)
            {
                merged.add(index,words.get(sindex));
                sindex++;
            }
            else if(sindex>high)
            {
                merged.add(index,words.get(findex));
                findex++;
            }
            else if(words.get(findex).compareTo(words.get(sindex))<0)
            {
                merged.add(index,words.get(findex));
                findex++;
            }
            else
            {
                merged.add(index,words.get(sindex));
                sindex++;
            }
        }
        for(int index=0;index<merged.size();index++)
        {
            words.set(low+index,merged.get(index));
        }
    }


    /**
     * Finds the parameter "txt" in the words list and returns the index
     * at which it is found. If txt is not in the words list, -1 is returned.
     * 
     * @postcondition   words has been sorted alphabetically
     * 
     * @param txt  the word to be found in words list 
     * @return the index in which txt was found in words list.  
     *         If txt is not in the words list, -1 is returned.
     */
    public int findWord(String txt)
    {
        sortWords( );
        return searchWord (txt, 0, words.size( ) - 1);
    }

    /**
     * Using a binary search, finds the  parameter txt in the words list and
     * returns the index at which it is found. If txt is not in the words list, 
     * a -1 is returned.
     * This is a helper method for findWord.
     * 
     * @precondition words list must be sorted alphabetically
     * 
     * @param txt  the word to be found in words list 
     * @param low    the smallest index to be used in this portion of the search
     * @param high   the last index to be used (inclusive) in this portion of 
     *               the search
     *               
     * @return the index in which txt was found in words list.  
     *         If txt is not in the words list, -1 is returned.
     */
    private int searchWord(String txt, int low, int high)
    {
        //base case
        if(low>high)
        {
            return -1;
        }
        int mid=(low+high)/2;
        int compare=words.get(mid).compareTo(txt);
        if(compare==0)
        {
            return retrieveMatches(mid,txt);
        }
        if(compare>0)
        {
            return searchWord(txt,low,mid-1);
        }
        return searchWord(txt,mid+1,high);
    }
    
    /**
     * 
     */
    private int retrieveMatches(int index,String txt)
    {
        int findex=index-1;
        int lindex=index+1;
        while(findex>=0&&words.get(findex).compareTo(txt)==0)
        {
            findex--;
        }
        findex++;
        while(lindex<words.size()&&words.get(lindex).compareTo(txt)==0)
        {
            lindex++;
        }
        lindex--;
        return lindex-findex+1;
    }
    
    /**
     * Add comments here even though you did not write the method.
     */
    public void printMenu()
    {
        System.out.println("\n\nEnter option: ");
        System.out.println("\t 1 - Print frequency of all words \n" +
            "\t 2 - Print frequency of top words \n" +
            "\t 3 - Print word at specified index \n" +
            "\t 4 - Print the word quotient \n" +
            "\t 5 - Print number of unique words \n" +
            "\t 6 - Print the total number of words \n" +
            "\t 7 - Print the frequency of the top words \n" +
            "\t 8 - Sort words alphabetically \n" + 
            "\t 9 - Find a specific word \n" +
            "\t10 - Quit \n");
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
            print();
        }
        else if (choice == 2)
        {
            System.out.print("\n\tHow many top words?\n\t");
            int num=in.nextInt();
            printTopWords(num);
        }
        else if (choice == 3)
        {
            System.out.print("\n\tWhat index do you want to print?\n\t");
            int num=in.nextInt();
            printWord(num);
        }
        else if(choice == 4)
        {
            System.out.print("\n\tHow many top words?\n\t");
            int num=in.nextInt();
            System.out.print(calculatePercentage(num));
        }
        else if(choice == 5)
        {
            System.out.print(getNumberOfUniqueWords());
        }
        else if(choice == 6)
        {
            System.out.print(sumWords());
        }
        else if(choice == 7)
        {
            System.out.print("\n\tHow many top words?\n\t");
            int num=in.nextInt();
            System.out.print(sumTopWords(num));
        }
        else if(choice == 8)
        {
            sortWords();
            print();
        }
        else if(choice == 9)
        {
            System.out.print("\n\tWhich word?\n\t");
            String word=in.next();
            System.out.print(findWord(word));
        }
        else if (choice == 10)
        {
            done = true;
        }  
        return done;
    }
    
    /**
     * Entry point into WordAnalysis.  It reads the input file and loops
     * until the user indicates that he or she is done.
     * 
     * @param  args         array with information that may be passed
     *                      at start of processing
     * @throws IOException  if file with the hurricane information cannot be found
     */
    public static void main (String [] args) throws IOException
    {
        WordAnalysis author = new WordAnalysis("MobyDick.txt");
        boolean areWeDoneYet = false;
        while ( ! areWeDoneYet)
        {
            areWeDoneYet = author.interactWithUser( );    
        }
    }
}
