import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.*;
public class rsa {
    public static int mod_inv(int a,int m)
    {
        a=a%m;
        for(int i=1;i<m;i++)
        {
            if((a*i)%m==1)
                return i;
        }
        return -1; // If no modular inverse found
    }
    public static void main(String args[]) throws Exception
    {
        Socket s=new Socket("localhost",5000);
        PrintWriter out=new PrintWriter(s.getOutputStream(),true);
        BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two prime nos p and q:");
        int p=sc.nextInt();
        int q=sc.nextInt();
        int n=p*q;
        int phi=(p-1)*(q-1);
        System.out.println("Enter e (1<e<"+phi+" and gcd(e,"+phi+")=1):");
        int e=sc.nextInt();
        int d=mod_inv(e,phi);
        System.out.println("Public Key: (e="+e+", n="+n+")");
        System.out.println("Private Key: (d="+d+", n="+n+")");
        out.println(n);
        out.println(e);
        String c=in.readLine();
        int C=Integer.parseInt(c);
        BigInteger M = BigInteger.valueOf(C).modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
System.out.println("Decrypted Message M received from server: " + M);

        
    }
}
