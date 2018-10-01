import java.util.Arrays;

public class NQueensLinearSpace {

    private static boolean test(int [] board, int lin, int col) {
        for (int i = 0; i < col ; i++) {
            // se duas damas estao na mesma diagonal a diferenca entre (i, j)
            // e (i2, j2) gera 2 valores 'l' e 'c' tal que l == c
            // (1, 2) e (2, 3) = abs(1 - 2) = 1 e abs(2 - 3) = 1
            // (0, 0) e (4, 4) = abs(0-4) == abs(0, 4)
            int l = Math.abs(board[i] - lin)
                , c = Math.abs(i - col);
            // mesma linha ou na mesma diagonal
            if (board[i] == lin || l == c)
                return false;
        }
        return true;
    }

    /**
     * board [] : tabuleiro de xadrez 1xn
     * board[i] : linha em que a i-esima rainha  se encontra
     *
     * queen: i-esima rainha a ser posicionada no tabuleiro
     * */
    private static void solver(int [] board, int n, int queen) {
        // linhas
        for (int lin = 0; lin < n ; lin++) {
            if (test(board, lin, queen)) {
                // a i-esima rainha esta na linha i
                board[queen] = lin;
                if (queen != n-1)
                    solver(board, n, queen+1);
                else
                    print(board, n);
            }
            else {
                board[queen] = -1;
            }
        }
    }

    private static void unique(int [] board, int n, int ith) {
        // linhas
        for (int lin = 0; lin<n; lin++) {
            if (test(board, lin, ith)) {
                // a i-esima rainha esta na linha i
                board[ith] = lin;
                if (ith != n-1)
                    unique(board, n, ith+1);
                else {
                    print(board, n);
                }
            }
        }
    }


    private static void print(int [] board, int n) {
        // linhas do tabuleiro
        for (int i = 0; i<n; i++) {
            // colunas do tabuleiro
            for (int j = 0; j<n ; j++) {
                // quando encontrarmos uma coluna no tabuleiro (board[i]) com o
                System.out.printf("%d", board[i] == j ? 1 : 0);
            }
            //System.out.printf(i == 0 ? "Linha: %d, Coluna: %d" : " ;Linha: %d, Coluna: %d", board[i], i);
            System.out.println("");
        }
        System.out.println("");
    }

    private static void solver(int n) {
        // tabuleiro NxN representado por um array
        // o indice do array representa a coluna e o valor a linha onde a Rainha esta posicionada
        int board [] = new int[n];
        Arrays.fill(board, -1);
        unique(board, n, 0);

    }

    public static void main(String[] args) {
        solver(4);
    }
}
