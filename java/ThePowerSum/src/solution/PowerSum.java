package solution;


import java.io.*;

import static java.lang.Math.pow;

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
        int b = solver(x-t, n, p+1);
        return a + b;
    }

    private static int solver(int x, int n) {
        int limit = (int)pow(x, 1.0/n) + 1;
        int memo [] = new int[x+1];
        // posicao 1 representa 1^n
        memo[1] = 1;
        for (int i = 1; i<limit ; i++) {
            /**
             * bottom up.
             *
             * */
            int t = (int) pow(i, n);
            /**
             *
             * */
            for (int j=x; j>t ; j--) {
                memo[j] += memo[j-t];
            }
        }
        return memo[x];
    }



    private static void run() {
        try {
            int x = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());
            writer.printf("%d", solver(x,n,1));
        } catch (IOException e) {}
    }

    public static void main(String[] args) {
        /*
        System.out.println(solver(13, 2, 1));
        //System.out.println(solver(13, 2));
        System.out.println(test(13, 2));
        */
        System.out.println(solver(100, 2, 1));
        //System.out.println(solver(100, 2));

        /*
        System.out.println(solver(5, 2, 1));
        System.out.println(solver(5, 2));

        System.out.println(solver(10, 2, 1));
        System.out.println(solver(10, 2));

        System.out.println(solver(9, 3, 1));
        System.out.println(solver(9, 3));
        */

    }
}
