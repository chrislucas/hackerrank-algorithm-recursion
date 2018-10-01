package solution;


/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * variacao interessante:
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * */

public class CoinChangeImpl {


    // f(n) = f(set, g, i-1) + f(set, g-set[i], i)

    private static int topDownApproach(int [] set,  long goal, int ith) {
        /**
         * se o valor objetivo for 0 quer dizer que existe uma solucao
         * (valor objetivo 0 = uma possivel solucao eh nao usar moeda alguma {})
         **/
        if (goal == 0) {
            return 1;
        }
        /**
         * Nao existe solucao. Usamos um valor dentro do conjunto que nao cabe na solucao (goal < 0)
         * ou
         * Nao existe mais moedas para usar e ainda nao chegamos a uma solucao (ith < 0)
         * */
        else if (goal < 0 || ith < 0) {
            return 0;
        }

        int a = topDownApproach(set, goal, ith-1); // solucoes sem a i-esima moeda do conjunto
        int b = topDownApproach(set, goal - set[ith], ith); // solucoes usando a i-esima moeda conjunto
        return a + b;
    }

    private static int memoization(int [] set, int g, int i, int mem [][]){
        if (g == 0)
            return 1;
        else if (g < 0 || i < 0)
            return 0;
        else if(mem[g][i] > 0)
            return mem[i][g];

        int a = memoization(set, g, i-1, mem);
        int b = memoization(set, g-set[i], i, mem);
        mem[i][g] = a + b;
        return mem[i][g];
    }

    private static int memoizationTest(int [] set, int g, int i) {
        int memo [][] = new int[i+1][g+1];
        for (int k = 0; k < g; k++) {
            memo[0][k] = 1;
        }
        return memoization(set, g, i, memo);
    }

    private static int bottomUpTest(int set [], int g, int i) {
        int memo [][] = new int [i][g+1];
        for (int j = 0; j < i; j++) {
            memo[j][0] = 1;
        }


        return memo[g][i];
    }

    /**
     * set - conjunto de moedas
     * g - valor objetivo
     * i - quantidade de moeadas
     * */
    private static int bottomUpApproachV1(int set [], int goal, int i) {

        /**
         * as g+1 linhas da matriz representam o g's subproblemas.
         * g = 0 => quantas formas podemos combinar i moedas tal que a soma seja 0
         * r: 1. Para g = 0 a solucao eh o conjunto vazio
         * E assim progredimos de 0 ate g construindo a solucao
         * */
        int memo [][] = new int[goal+1][i+1];

        /**
         * quando o valor objetivo for zero a resposta para
         * o problema eh 1, nao importa o conjunto de moedas usados
         * a resposta eh 1 conjunto vazio
         * */
        for (int k = 0; k<i+1; k++) {
            memo[0][k] = 1;
        }

        for (int previous = 1; previous < goal+1 ; previous++) {
            for (int idx = 0; idx < i+1; idx++) {
                // verificando se a i-esima moeda foi usada na solucao do problema cujo objetivo
                // era ativer o valor na variabel 'goal'
                int p = previous - set[idx];
                /**
                 * se p > 0, memo[previous][idx] indicara
                 * se o valor em set[idx] foi utilizado na solucao cujo objetivo era a variavel 'goal'
                 * */
                //  se a i-esima moeda for usada na subsoluca, use o seu valor senao use 0
                int a = p >= 0 ? memo[p][idx] : 0;
                // considerar na solucao somente as (i-1) moedas
                int b = idx > 0 ? memo[previous][idx-1] : 0;
                // solucao considerando usar a idx-esima moeda + nao usa-la
                memo[previous][idx] = a + b;
            }
        }
        return memo[goal][i];
    }

    private static int bottomUpV2(int [] set, int g, int i) {
        int [] mem = new int[i+1];
        mem[0] = 1;
        for (int j = 1; j < g ; j++) {
            for (int k = 0; k < i; k++) {

            }
        }
        return mem[i];
    }

    public static void main(String[] args) {
        int [][] sets = {
                  {7,8,9}
                , {1,2,3}
                , {1,2,3}
                , {1,2,3}
                , {7,8,9}
                , {2, 5, 3, 6}
                , {5, 10, 25}
                , {1, 5, 6, 9}
        };
        int goals [] = {4, 4, 5, 2,  7,  10, 30, 11};
        int idx = 3;
        System.out.println(topDownApproach(sets[idx], goals[idx], sets[idx].length-1));;
        //System.out.println(memoizationTest(sets[idx], goals[idx], sets[idx].length-1));
        System.out.println(bottomUpApproachV1(sets[idx], goals[idx], sets[idx].length-1));
    }
}
