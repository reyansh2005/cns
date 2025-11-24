import java.util.*;

public class playfair2 {

    // Find position of a character in matrix
    static int[] findPos(char[][] mat, char ch) {
        if (ch == 'J') ch = 'I';
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (mat[i][j] == ch)
                    return new int[]{i, j};
        return null;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter plaintext: ");
        String p = sc.nextLine();

        System.out.println("Enter key: ");
        String k = sc.nextLine();

        String P = p.toUpperCase().replace("J", "I").replace(" ", "");
        String K = k.toUpperCase().replace("J", "I");

        // Remove duplicate letters from key
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : K.toCharArray())
            if (c >= 'A' && c <= 'Z')
                set.add(c);

        StringBuilder key2 = new StringBuilder();
        for (char c : set) key2.append(c);
        K = key2.toString();

        // Build 5x5 matrix
        char mat[][] = new char[5][5];
        String extra = "";

        // Fill remaining alphabet except ones in key
        for (int i = 0; i < 26; i++) {
            char ch = (char)(i + 'A');
            if (ch == 'J') continue;
            if (!K.contains("" + ch)) extra += ch;
        }

        // Fill key in matrix
        int x = 0;
        int idx = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (x < K.length()) {
                    mat[i][j] = K.charAt(x++);
                } else {
                    mat[i][j] = extra.charAt(idx++);
                }
            }
        }

        // Display matrix
        System.out.println("\nPlayfair Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }

        // Prepare plaintext pairs
        StringBuilder pairs = new StringBuilder();
        for (int i = 0; i < P.length(); i++) {
            pairs.append(P.charAt(i));
            if (i + 1 < P.length()) {
                if (P.charAt(i) == P.charAt(i + 1))
                    pairs.append('X');
                else {
                    pairs.append(P.charAt(i + 1));
                    i++;
                }
            } else {
                pairs.append('X');
            }
        }

        System.out.println("\nPairs: " + pairs);

        // Encrypt pairs
        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < pairs.length(); i += 2) {
            char a = pairs.charAt(i);
            char b = pairs.charAt(i + 1);

            int[] p1 = findPos(mat, a);
            int[] p2 = findPos(mat, b);

            int r1 = p1[0], c1 = p1[1];
            int r2 = p2[0], c2 = p2[1];

            char c1e, c2e;

            if (r1 == r2) {
                // same row → move right
                c1e = mat[r1][(c1 + 1) % 5];
                c2e = mat[r2][(c2 + 1) % 5];
            } 
            else if (c1 == c2) {
                // same column → move down
                c1e = mat[(r1 + 1) % 5][c1];
                c2e = mat[(r2 + 1) % 5][c2];
            } 
            else {
                // rectangle rule → swap columns
                c1e = mat[r1][c2];
                c2e = mat[r2][c1];
            }

            cipher.append(c1e).append(c2e);
        }

        System.out.println("\nCiphertext: " + cipher);
    }
}
