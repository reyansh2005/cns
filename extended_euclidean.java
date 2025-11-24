import java.util.*;
public class extended_euclidean {
    public static int extendedGCD(int a,int b)
    {
        int s0=1;
        int s1=0;
        int t0=0;
        int t1=1;
        while(b!=0)
        {
            int q=a/b;
            int r=a%b;
            int s=s0-q*s1;
            int t=t0 - q*t1;
            a=b;
            b=r;
            s0=s1;
            s1=s;
            t0=t1;
            t1=t;

        }
        System.out.println("Coefficients are: s="+s0+" t="+t0); // Bézout coefficients s*a + t*b = GCD(a,b)
        return a; // GCD
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int gcd=extendedGCD(a,b);
        System.out.println("GCD is: "+gcd);
    }
}
