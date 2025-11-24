import java.util.*;
import java.net.*;
import java.io.*;
import java.math.BigInteger;
public class rsa_server {
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        ServerSocket ss =new ServerSocket(5000);
        Socket s=ss.accept();
        BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out=new PrintWriter(s.getOutputStream(),true);
          String n=in.readLine();
        System.out.println("Enter message M (M<"+n+"):");
        int M=sc.nextInt();
  
        String e=in.readLine();
      
        
        int E=Integer.parseInt(e);
        int N=Integer.parseInt(n);

        System.out.println("Public Key received from client: (e="+E+", n="+N+")");
        BigInteger C = BigInteger.valueOf(M).modPow(BigInteger.valueOf(E), BigInteger.valueOf(N));
        out.println(C.toString());
        System.out.println("Encrypted Message C sent to client: "+C);
        
       
    }
}
