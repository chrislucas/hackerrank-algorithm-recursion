public class NQueensAllSolutions {

    private static boolean test(boolean [][] board, int lin, int col) {
        int n = board[0].length;
        // verificar se tem uma rainha na mesma linha que estamos querendo posicionar outra
        for (int i = 0; i < col ; i++) {
            if (board[lin][i])
                return false;
        }
        // verificar os campos na diagonal principal cima da linha e coluna escolhido para posicionar uma rainha
        for (int i=lin, j=col; i > -1 && j > -1 ; i--, j--) {
            if (board[i][j])
                return false;
        }
        // verificar os campos na diagonal secundario
        for (int i=lin, j=col; i < n && j > -1; i++, j--) {
            if (board[i][j])
                return false;
        }
        return true;
    }

    private static int acc = 0;

    private static boolean solver(boolean [][] board, int n, int c) {
        if (c == n) {
            System.out.println(++acc);
            print(board, n);
            return true;
        }
        boolean ans = false;
        // iterando pelas linhas do tabuleiro
        for (int lin = 0; lin < n ; lin++) {
            if (test(board, lin, c)) {
                board[lin][c] = true;
                ans = solver(board, n, c+1) || ans;
                // backtracking, voltar a coluna anterior e remover a rainha posicionada
                board[lin][c] = false;
            }
        }
        return ans;
    }

    private static void solver(int n) {
        if (n < 2)
            return;
        boolean [][] board = new boolean[n][n];
        solver(board, n, 0);
    }

    private static void print(boolean [][] board, int n) {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.printf("%s ", board[i][j] ? "1" : "0");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        solver(10);
    }
}
