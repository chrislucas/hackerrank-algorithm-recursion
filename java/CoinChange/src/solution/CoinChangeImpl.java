package solution;


/**
 * variacao interessante:
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * */

public class CoinChangeImpl {


    public static long topDownApproach(long [] set,  long goal, int ith) {
        /**
         * se o valor objetivo for 0 quer dizer que existe uma solucao
         * (valor objetivo 0 = uma possivel solucao eh nao usar moeda alguma {})
         **/
        if (goal == 0) {
            return 1;
        }
        /**
         * Nao existe solucao. Usamos um valor dentro do conjunto que nao cabe na solucao ou
         * */
        else if (goal < 0) {
            return 0;
        }
        /**
         * Nao existe mais moedas para usar e ainda nao chegamos a uma solucao
         * */
        else if(ith < 0) {
            return 0;
        }
        long a = topDownApproach(set, goal, ith-1);
        long b = topDownApproach(set, goal - set[ith], ith);
        return a + b;
    }

    public static void main(String[] args) {
        long [][] sets = { {1,2,3}, {2, 5, 3, 6}};
        long goals [] = {4, 10};
        int idx = 0;
        System.out.println(topDownApproach(sets[idx], goals[idx], sets[idx].length-1));;
    }
}
