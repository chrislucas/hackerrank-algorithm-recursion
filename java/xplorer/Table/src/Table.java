public class Table {


    private static void multipleFrom0ToN(int n) {
        if (n < 0)
            return;
        multipleFrom0ToN(n-1);
        for (int i = 0; i < 11; i++) {
            System.out.printf("%d x %d = %d\n", n, i, n * i);
        }
        System.out.println("");
    }

    private static void multiple(int n) {
        multiple(n, n);
    }
    private static void multiple(int n, int m) {
        if (m < 0)
            return;
        multiple(n, m-1);
        System.out.printf("%d x %d = %d\n", n, m, n * m);
    }

    public static void main(String[] args) {
        multiple(10);
    }
}
