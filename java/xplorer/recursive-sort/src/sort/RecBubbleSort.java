package sort;

import java.util.Random;

public class RecBubbleSort {


    private static void sort(Comparable [] data, int n) {
        if (n < 1)
            return;
        for (int i = 0; i < n-1 ; i++) {
            if (data[i].compareTo(data[i+1]) > 0) {
                Comparable aux = data[i];
                data[i] = data[i+1];
                data[i+1] = aux;
            }
        }
        sort(data, n-1);
    }

    private static Integer [] scrambleInt(int n) {
        Integer array [] = new Integer[n];
        for (int i = 0; i < n ; i++) {
            array[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < n ; i++) {
            int idx = random.nextInt(n - i) + i;
            int aux = array[i];
            array[i] = array[idx];
            array[idx] = aux;
        }
        return array;
    }

    public static void main(String[] args) {
        //Comparable [] data = {"Christoffer", "Alan", "Amanda", "Fernanda", "Alex"};
        Comparable [] data = scrambleInt(35);
        for (Comparable comp : data) {
            System.out.printf("%s ", comp);
        }
        System.out.println("");
        sort(data, data.length);
        for (Comparable comp : data) {
            System.out.printf("%s ", comp);
        }
        System.out.println("");
    }


}
