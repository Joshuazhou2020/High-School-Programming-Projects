public class Runner
{
    public static void main(String[] args)
    {
        Object obj=new Object();
        System.out.println(obj);
        System.out.println(obj.toString());
        
        Object str=new String("Hello World!");
        System.out.println(str);
        System.out.println(str.toString());
        
        int index=((String)str).indexOf("ell");
    }
}