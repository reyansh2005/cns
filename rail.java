import java.util.*;
public class rail {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String p=sc.nextLine();
        int key=sc.nextInt();
        char rail[][]=new char[key][p.length()];
        int row=0;
        int dir=1;
        for(int i=0;i<p.length();i++)
        {
            rail[row][i]=p.charAt(i);
            if(row==0)
                dir=1;
            else if(row==key-1)
                dir=-1;
            row+=dir;
        }
        String res = "";
        for (int i = 0; i < key; i++)
            {for (int j = 0; j < p.length(); j++)
                {if (rail[i][j] != 0)
                    res += rail[i][j];}
        }
        System.out.println(res);
    }
}
