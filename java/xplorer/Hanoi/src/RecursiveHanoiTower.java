public class RecursiveHanoiTower {

    // s = start, i = intermediary, d=destiny
    private static void solver(int n, char s, char d, char i) {
        if (n < 1)
            return;
        // o disco N vai do PINO de partida para PINO auxiliar (1, 3)
        solver(n-1, s, i, d);
        System.out.printf("Disc %d From %s To %s\n", n, s, d);
        // o disco N vai do PINO auxiliar para o pino de destino.
        // Pino 3 passa ser o pino de inicio, 2 continua como destino e o pino 1 passa a ser o auxiliar
        solver(n-1, i, d, s);
    }


    public static void main(String[] args) {
        //solver(3, '1', '2', '3');
    }

}
