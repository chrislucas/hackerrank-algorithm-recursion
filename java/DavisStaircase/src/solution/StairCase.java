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

    private static int anotherWay(int n) {
        if (n == 1)
            return 1;

        int m = n+1;
        int memo[][] = new int[m][m];

        for (int i = 0; i<m ; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i<m ; i++) {
            for (int j = 1; j<m ; j++) {

            }
        }
        return memo[n][n];
    }

    public static void main(String[] args) {
        System.out.println(stepPerms(6));
        int [] memo = new int[6];
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
