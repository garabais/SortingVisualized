public class ShellSort {

    public static void sort(Value[] arr, DrawPanel dp){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //Do a gap insertion sort
            for (int i = gap; i < arr.length; i++) {
                Value aux = arr[i];
                int j;
                //shifting until being sorted
                for (j = i; j >= gap && arr[j - gap].compareTo(aux) > 0 ; j-= gap) {
                    ((Value) arr[j]).setComparable();
                    dp.repaint();
                    dp.sleep();
                    arr[j] = arr[j-gap];
                }
                arr[j] = aux;
            }
        }
    }

}
