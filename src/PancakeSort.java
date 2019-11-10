public class PancakeSort {

    public static void sort(Value[] arr, DrawPanel dp) {
        // reduce the size of the array one by one
        for (int i = arr.length; i > 1; --i) {
            // find the position of the maximum value
            int max = getMax(arr, i, dp);
            // move the max value to the end
            if(max != (i - 1)){
                // the max to the beginning
                flip(arr, max, dp);
                // reverse the array
                flip(arr, i - 1, dp);
            }
        }
    }

    public static int getMax(Value[] arr, int size, DrawPanel dp) {
        int max = 0;
        for(int i = 0; i < size; ++i) {
            arr[i].setComparable();
            arr[max].setComparable();
            dp.repaint();
            dp.sleep();
            max = arr[i].compareTo(arr[max]) > 0 ? i : max;
        }
        return max;
    }

    public static void flip(Value[] arr, int i, DrawPanel dp){
        int start = 0;
        while(start < i){
            arr[i].setComparable();
            arr[start].setComparable();
            dp.repaint();
            dp.sleep();
            swap(arr, i, start);
            start++;
            i--;
        }
    }

    private static <E> void swap(E[] datos, int i, int j) {
        E aux = datos[j];
        datos[j] = datos[i];
        datos[i] = aux;
    }

}
