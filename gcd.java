import java.util.*;
class gcd
{
    public static int GCD(int a,int b)
    {
        return (b==0)?a:GCD(b,a%b);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("GCD of "+a+" and "+b+" is: "+GCD(a,b));

    }
}