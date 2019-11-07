import java.awt.*;

public class HeapSort {

    public static void sort(Value[] arr, DrawPanel dp){
        for (int i = arr.length/2 - 1; i >= 0; i--){
            heapify(arr, arr.length, i, dp);
        }
        for (int i = arr.length - 1; i >= 0 ; i--) {
            arr[0].setComparable();
            arr[i].setComparable();
            dp.repaint();
            dp.sleep();
            Value aux = arr[0];
            arr[0] = arr[i];
            arr[i] = aux;
            heapify(arr,i,0,dp);
        }
    }

    public static void heapify(Value[] arr, int lenght, int i, DrawPanel dp){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // If left child is larger than root
        if (left < lenght && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < lenght && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        // If largest is not root
        if (largest != i)
        {
            arr[i].setComparable();
            arr[largest].setComparable();
            dp.repaint();
            dp.sleep();
            Value aux = arr[i];
            arr[i] = arr[largest];
            arr[largest] = aux;

            // Recursively heapify the affected sub-tree
            heapify(arr, lenght, largest, dp);
        }
    }

}
