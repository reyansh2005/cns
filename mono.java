import java.util.*;
public class mono {
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        String p=sc.nextLine();
        String k=sc.nextLine();
        String ans="";
        for(int i=0;i<p.length();i++)
        {
            char c=p.charAt(i);
            if(Character.isLetter(c))
            {
                char b=k.charAt((int)c-(int)(Character.isLowerCase(c)?'a':'A'));
                ans+=b;
            }
        }
        System.out.println("Ciphertext: " + ans);
    }
}
