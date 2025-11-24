import java.util.*;
public class poly {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String p=sc.nextLine();
        String k=sc.nextLine();
        String ans="";
        if(p.length()>k.length())
        {
            String k1=k;
            
            int a=p.length()-k.length();
            for(int i=0;i<a;i++)
            {
                k1+=k.charAt(i);
            }
                k=k1;

        }
        for(int i=0;i<p.length();i++)
        {
            ans+=(char)((char)(((int)p.charAt(i)+(int)k.charAt(i))%26)+'A');
        }
        System.out.println("Ciphertext: " + ans);
        String dec="";
        for(int i=0;i<ans.length();i++)
        {
            dec+=(char)(((int)ans.charAt(i)-(int)k.charAt(i)+26)%26 +'A');
        }
        System.out.println("Decrypted text: " + dec);

    }
}
