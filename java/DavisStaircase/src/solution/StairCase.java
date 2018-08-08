package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=recursion-backtracking
 * */

public class StairCase {


    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    private static final long MOD = (long) (10E9+7);

    private static int sm(int a, int b) {
        return (int) ((a % MOD + b % MOD) % MOD);
    }

    // Complete the stepPerms function below.
    private static int stepPerms(int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 0;
        int a = stepPerms(n-1);
        int b = stepPerms(n-2);
        int c = stepPerms(n-3);
        return sm(sm(a, b), c);
    }

    private static int stepPerms(int n, int table []) {
        if (n == 0) {
            return 1;
        }
        else if (n < 0) {
            return 0;
        }
        else if (table[n] != 0){
            return table[n];
        }
        int a = stepPerms(n-1, table);
        int b = stepPerms(n-2, table);
        int c = stepPerms(n-3, table);
        table[n] = sm(sm(a, b), c);
        return table[n];
    }

    private static int anotherWay(int n) {
        int memo[] = new int [3];
        memo[0] = 1;
        memo[1] = 2;
        memo[2] = 4;
        if (n < 4)
            return memo[n-1];
        for (int i = 3; i<n; i++) {
            int acc = 0;
            acc = sm(memo[0], sm(memo[1], sm(memo[2], acc)));
            memo[i%3] = acc;
        }
        return memo[(n-1)%3];
    }

    public static void main(String[] args) {

        for (int i = 7; i < 37 ; i++) {
            //System.out.println(stepPerms(i));
            int [] memo = new int[i+1];
            memo[1] = 1;
            System.out.println(stepPerms(i, memo));
            System.out.println(anotherWay(i));
            System.out.println("");
        }


        /*
        System.out.println(stepPerms(2));
        System.out.println(anotherWay(2));

        System.out.println(stepPerms(3));
        System.out.println(anotherWay(3));

        System.out.println(stepPerms(4));
        System.out.println(anotherWay(4));

        System.out.println(stepPerms(7));
        System.out.println(anotherWay(7));

        System.out.println(anotherWay(36));
        System.out.println(stepPerms(36));
        */
    }
}
