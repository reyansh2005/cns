import java.util.*;
public class caeser_cipher {
  
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plaintext:");
        String plain = sc.nextLine();
        System.out.println("Enter shift value:");
        int shift = sc.nextInt();
        String ans="";
        for(int i=0;i<plain.length();i++)
        {
            char ch=plain.charAt(i);
            if(Character.isLetter(ch))
            {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char)((((ch - base) + shift) % 26) + base);
            }
            ans+=ch;
        }
        System.out.println("Ciphertext: " + ans);

       
    }
}