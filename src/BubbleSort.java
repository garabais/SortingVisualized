public class BubbleSort {

    public static void sort(Value[] arr, DrawPanel dp) {
        boolean change = true;
        for(int i = 0; i < arr.length-1 && change;i++) {
            change = false;
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if (dp.isStoped()) {
                    dp.repaint();
                    return;
                }
                arr[j].setComparable();
                dp.repaint();
                dp.sleep();
                if(arr[j].compareTo(arr[j+1]) > 0) {
                    change = true;
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(Value[] datos, int i, int j) {
        Value aux = datos[j];
        datos[j] = datos[i];
        datos[i] = aux;
    }

}
