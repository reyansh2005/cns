import java.util.*;
public class playfair {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String p=sc.nextLine();
        String k=sc.nextLine();
        String P=p.toUpperCase().replace("J","I");
        String K=k.toUpperCase().replace("J","I");
        System.out.println(K);
        char mat[][]=new char [5][5];
     String aa="";
     for(int i=0;i<26;i++)
        {
            if(K.contains((Character.toString((char)(i+'A')))) || i+'A'=='J')
            {
                continue;
            
            }
            else
            {
                aa+=(Character.toString((char)(i+'A')));
            }
        }
     
         int x= 0;
        for(int i=0;i<5;i++)
        
        {
            for(int j=0;j<5;j++)
            {
               if(x==K.length())
                        {
                            break;
                        }
                        mat[i][j]=K.charAt(x);
                         
                        x++;
                       
                        

                       
            }
        }
        int y=0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(mat[i][j]==0)
                {
                    mat[i][j]=aa.charAt(y);
                    y++;

                }
                
            }
            System.out.println();
        }
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }


    }
}
