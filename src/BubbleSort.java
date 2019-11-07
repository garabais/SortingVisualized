import java.util.Random;

public class BubbleSort {

    public static <E extends Comparable<E>> void sort(E[] arr, DrawPanel dp) {
        boolean change = true;
        for(int i = 0; i < arr.length-1 && change;i++) {
            change = false;
            for(int j = 0; j < arr.length - 1 - i; j++) {
                ((Value) arr[j]).setComparable();
                dp.repaint();
                dp.sleep();
                if(arr[j].compareTo(arr[j+1]) > 0) {
                    change = true;
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static <E> void swap(E[] datos, int i, int j) {
        E aux = datos[j];
        datos[j] = datos[i];
        datos[i] = aux;
    }

}
