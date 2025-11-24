public class ellipse{

    // curve parameters: y^2 = x^3 + ax + b mod p
    static int a = 2;
    static int b = 3;
    static int p = 17;     // prime field

    // modular inverse (small + simple)
    static int modInverse(int x, int mod) {
        for (int i = 1; i < mod; i++)
            if ((x * i) % mod == 1)
                return i;
        return -1;
    }

    // add two points (x1,y1) + (x2,y2)
    static void add(int x1, int y1, int x2, int y2) {

        int lambda;

        if (x1 == x2 && y1 == y2) {
            // point doubling
            int num = (3 * x1 * x1 + a) % p;
            int den = modInverse(2 * y1, p);
            lambda = (num * den) % p;
        } else {
            // point addition
            int num = (y2 - y1 + p) % p;
            int den = modInverse((x2 - x1 + p) % p, p);
            lambda = (num * den) % p;
        }

        int x3 = (lambda * lambda - x1 - x2) % p;
        if (x3 < 0) x3 += p;

        int y3 = (lambda * (x1 - x3) - y1) % p;
        if (y3 < 0) y3 += p;

        System.out.println("Result: (" + x3 + ", " + y3 + ")");
    }

    public static void main(String[] args) {
        // Example points on curve y^2 = x^3 + 2x + 3 mod 17
        add(5, 1, 6, 3);   // P + Q
    }
}
