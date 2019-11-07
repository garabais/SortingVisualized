public class CombSort {

    public static void sort(Value[] arr, DrawPanel dp) {
        int gap = arr.length;
        boolean change = true;
        while (change || gap != 1){
            //gap factor of 1.3
            gap = (gap * 10)/13;
            gap = gap >= 1 ? gap : 1;
            change = false;
            for (int i = 0; i < arr.length - gap; i++) {
                arr[i].setComparable();
                dp.repaint();
                dp.sleep();
                if(arr[i].compareTo(arr[i + gap]) > 0){

                    swap(arr, i, i+gap);
                    change = true;
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
