package solution;


import java.io.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class PowerSum {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    private static int solver(int x, int n, int p) {
        int t = (int)pow(p, n);
        if (t == x)
            return 1;
        else if(t > x)
            return 0;
        int a = solver(x, n, p+1);
        int b = solver(x-(int)pow(p, n), n, p+1);
        return a + b;
    }

    private static int solver(int x, int n) {
        int acc = 0;
        int limit = (int)pow(x, 1.0/n) + 1;
        for (int i = 1; i<=limit ; i++) {
            int p = (int)pow(i, n);
            int q = x - p;
            System.out.printf("%d %d\n", p, q);
        }
        return acc;
    }

    private static void run() {
        try {
            int x = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());
            writer.printf("%d", solver(x,n,1));
        } catch (IOException e) {}
    }

    public static void main(String[] args) {

        System.out.println(solver(10, 2, 1));
        System.out.println(solver(10, 2));
        /*
        System.out.println(solver(5, 2, 1));
        System.out.println(solver(5, 2));
        System.out.println(solver(100, 2, 1));
        System.out.println(solver(100, 2));
        System.out.println(solver(13, 2, 1));
        System.out.println(solver(13, 2));
        */
    }
}
