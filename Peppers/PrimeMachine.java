import java.util.Scanner;
/**
 * Write a description of class PrimeMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrimeMachine
{
    public boolean isPrime(int num)
    {
        for(int i=1; i<=num; i++)
        {
            if(num%i==0)
            {
                if(i!=num&&i!=1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public void interact()
    {
        System.out.println("Input a number: ");
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        in.nextLine();
        
        if(isPrime(num))
        {
            System.out.println("This number is prime \n");
        }
        else
        {
            System.out.println("This number is composite \n");
        }
    }
    public final static void main(String[] args)
    {
        boolean runner=true;
        while(runner)
        {
            PrimeMachine mathSolver=new PrimeMachine();
            mathSolver.interact();
        }
    }
}